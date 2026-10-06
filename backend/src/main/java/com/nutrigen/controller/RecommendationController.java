package com.nutrigen.controller;
import com.nutrigen.repository.UserRepository; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/recommendations")
public class RecommendationController{
 private final UserRepository users; public RecommendationController(UserRepository u){users=u;}
 @GetMapping("/{id}") public Map<String,Object> get(@PathVariable Long id){
  var u=users.findById(id).orElseThrow(); String g=u.getGoal()==null?"maintain":u.getGoal().toLowerCase();
  List<String>s=g.contains("loss")?List.of("Oats + eggs","Grilled chicken/paneer salad","Dal + vegetables","Greek yogurt + fruit"):g.contains("gain")?List.of("Oats + milk + banana + nuts","Chicken/paneer rice bowl","Dal + roti + vegetables","Curd + nuts + fruit"):List.of("Vegetable poha + eggs","Dal + rice + vegetables","Chicken/paneer + roti + salad","Fruit + yogurt");
  return Map.of("goal",g,"dailyCalories",u.getDailyCalories(),"dailyProtein",u.getDailyProtein(),"suggestions",s);
 }
}
