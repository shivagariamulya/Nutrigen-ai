package com.nutrigen.model;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class UserProfile {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false) private String name;
 private Integer age; private Double heightCm; private Double weightKg;
 private String gender; private String activityLevel; private String goal;
 private Double dailyCalories=2000.0, dailyProtein=100.0, dailyCarbs=250.0, dailyFat=65.0;
 public Long getId(){return id;} public String getEmail(){return email;} public String getPassword(){return password;} public String getName(){return name;}
 public Integer getAge(){return age;} public Double getHeightCm(){return heightCm;} public Double getWeightKg(){return weightKg;}
 public String getGender(){return gender;} public String getActivityLevel(){return activityLevel;} public String getGoal(){return goal;}
 public Double getDailyCalories(){return dailyCalories;} public Double getDailyProtein(){return dailyProtein;} public Double getDailyCarbs(){return dailyCarbs;} public Double getDailyFat(){return dailyFat;}
 public void setEmail(String v){email=v;} public void setPassword(String v){password=v;} public void setName(String v){name=v;} public void setAge(Integer v){age=v;}
 public void setHeightCm(Double v){heightCm=v;} public void setWeightKg(Double v){weightKg=v;} public void setGender(String v){gender=v;}
 public void setActivityLevel(String v){activityLevel=v;} public void setGoal(String v){goal=v;} public void setDailyCalories(Double v){dailyCalories=v;}
 public void setDailyProtein(Double v){dailyProtein=v;} public void setDailyCarbs(Double v){dailyCarbs=v;} public void setDailyFat(Double v){dailyFat=v;}
}
