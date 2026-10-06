package com.nutrigen.repository;
import com.nutrigen.model.Meal; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
public interface MealRepository extends JpaRepository<Meal,Long>{
 List<Meal> findByUserIdOrderByCreatedAtDesc(Long id);
 List<Meal> findByUserIdAndMealDateBetween(Long id,LocalDate from,LocalDate to);
}
