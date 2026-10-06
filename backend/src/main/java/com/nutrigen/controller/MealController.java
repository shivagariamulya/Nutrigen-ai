package com.nutrigen.controller;
import com.nutrigen.model.*; import com.nutrigen.repository.*; import com.nutrigen.service.FoodAnalysisService;
import org.springframework.http.MediaType; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile; import java.time.LocalDate; import java.util.*;
@RestController @RequestMapping("/api/meals")
public class MealController{
 private final MealRepository meals; private final UserRepository users; private final FoodAnalysisService ai;
 public MealController(MealRepository m,UserRepository u,FoodAnalysisService a){meals=m;users=u;ai=a;}
 @PostMapping(value="/analyze",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
 public FoodAnalysisService.Result analyze(@RequestParam Long userId,@RequestParam MultipartFile image,@RequestParam(required=false) String portion){return ai.analyze(image,portion);}
 @PostMapping public Meal save(@RequestBody Map<String,Object>b){
  UserProfile u=users.findById(Long.valueOf(b.get("userId").toString())).orElseThrow(); Meal m=new Meal();m.setUser(u);m.setFoodName((String)b.get("foodName"));m.setPortion((String)b.get("portion"));m.setImageName((String)b.get("imageName"));m.setCalories(Double.valueOf(b.get("calories").toString()));m.setProtein(Double.valueOf(b.get("protein").toString()));m.setCarbohydrates(Double.valueOf(b.get("carbohydrates").toString()));m.setFats(Double.valueOf(b.get("fats").toString()));return meals.save(m);
 }
 @GetMapping("/user/{id}") public List<Meal> history(@PathVariable Long id){return meals.findByUserIdOrderByCreatedAtDesc(id);}
 @GetMapping("/summary/{id}") public Map<String,Object> summary(@PathVariable Long id,@RequestParam(defaultValue="7")int days){
  LocalDate to=LocalDate.now(),from=to.minusDays(days-1);var l=meals.findByUserIdAndMealDateBetween(id,from,to);
  return Map.of("from",from,"to",to,"meals",l.size(),"calories",sum(l,0),"protein",sum(l,1),"carbohydrates",sum(l,2),"fats",sum(l,3));
 }
 private double sum(List<Meal>l,int n){return l.stream().mapToDouble(m->n==0?m.getCalories():n==1?m.getProtein():n==2?m.getCarbohydrates():m.getFats()).sum();}
}
