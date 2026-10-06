package com.nutrigen.controller;
import com.nutrigen.model.UserProfile; import com.nutrigen.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/auth")
public class AuthController{
 private final UserRepository users; private final PasswordEncoder encoder;
 public AuthController(UserRepository u,PasswordEncoder e){users=u;encoder=e;}
 @PostMapping("/register") public Map<String,Object> register(@RequestBody Map<String,String> b){
  UserProfile u=new UserProfile(); u.setName(b.getOrDefault("name","User")); u.setEmail(b.get("email")); u.setPassword(encoder.encode(b.get("password"))); users.save(u); return safe(u);
 }
 @PostMapping("/login") public Map<String,Object> login(@RequestBody Map<String,String> b){
  UserProfile u=users.findByEmail(b.get("email")).orElseThrow(); if(!encoder.matches(b.get("password"),u.getPassword())) throw new RuntimeException("Invalid credentials"); return safe(u);
 }
 private Map<String,Object> safe(UserProfile u){return Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail());}
}
