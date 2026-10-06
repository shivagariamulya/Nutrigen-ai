package com.nutrigen.service;
import org.springframework.stereotype.Service; import org.springframework.web.multipart.MultipartFile;
@Service public class FoodAnalysisService{
 public record Result(String foodName,String portion,double calories,double protein,double carbohydrates,double fats){}
 public Result analyze(MultipartFile image,String portion){
  String n=image.getOriginalFilename()==null?"":image.getOriginalFilename().toLowerCase();
  if(n.contains("chicken")) return new Result("Chicken meal",portionOrDefault(portion),420,38,25,16);
  if(n.contains("rice")) return new Result("Rice meal",portionOrDefault(portion),320,7,68,3);
  if(n.contains("egg")) return new Result("Egg meal",portionOrDefault(portion),280,18,12,18);
  if(n.contains("salad")) return new Result("Salad",portionOrDefault(portion),180,8,20,8);
  return new Result("Mixed meal",portionOrDefault(portion),450,20,55,15);
 }
 private String portionOrDefault(String p){return p==null||p.isBlank()?"1 serving":p;}
}
