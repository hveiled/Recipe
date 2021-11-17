package recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.model.Recipe;

import javax.swing.*;
import java.util.List;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long> {
    List<Recipe> findDistinctByNameContainingIgnoreCaseOrderByDateDesc(String name);
    List<Recipe> findDistinctByCategoryIgnoreCaseOrderByDateDesc(String category);
}
