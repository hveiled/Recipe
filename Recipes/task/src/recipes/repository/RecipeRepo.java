package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.model.Recipe;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long> {
}