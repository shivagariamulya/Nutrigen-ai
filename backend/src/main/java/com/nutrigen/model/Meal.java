package com.nutrigen.model;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="meals")
public class Meal {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private UserProfile user;
 private String imageName,foodName,portion; private Double calories,protein,carbohydrates,fats;
 private LocalDate mealDate=LocalDate.now(); private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public UserProfile getUser(){return user;} public void setUser(UserProfile v){user=v;}
 public String getImageName(){return imageName;} public void setImageName(String v){imageName=v;} public String getFoodName(){return foodName;} public void setFoodName(String v){foodName=v;}
 public String getPortion(){return portion;} public void setPortion(String v){portion=v;} public Double getCalories(){return calories;} public void setCalories(Double v){calories=v;}
 public Double getProtein(){return protein;} public void setProtein(Double v){protein=v;} public Double getCarbohydrates(){return carbohydrates;} public void setCarbohydrates(Double v){carbohydrates=v;}
 public Double getFats(){return fats;} public void setFats(Double v){fats=v;} public LocalDate getMealDate(){return mealDate;} public LocalDateTime getCreatedAt(){return createdAt;}
}
