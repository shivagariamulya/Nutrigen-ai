package com.nutrigen.controller;
import com.nutrigen.model.UserProfile; import com.nutrigen.repository.UserRepository; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/users")
public class ProfileController{
 private final UserRepository users; public ProfileController(UserRepository u){users=u;}
 @GetMapping("/{id}") public UserProfile get(@PathVariable Long id){return users.findById(id).orElseThrow();}
 @PutMapping("/{id}") public UserProfile update(@PathVariable Long id,@RequestBody UserProfile x){
  UserProfile u=users.findById(id).orElseThrow(); u.setName(x.getName());u.setAge(x.getAge());u.setHeightCm(x.getHeightCm());u.setWeightKg(x.getWeightKg());u.setGender(x.getGender());u.setActivityLevel(x.getActivityLevel());u.setGoal(x.getGoal());u.setDailyCalories(x.getDailyCalories());u.setDailyProtein(x.getDailyProtein());u.setDailyCarbs(x.getDailyCarbs());u.setDailyFat(x.getDailyFat()); return users.save(u);
 }
}
