package recipes.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import recipes.model.Directions;
import recipes.model.Ingredients;
import recipes.model.Recipe;
import recipes.repository.RecipeRepo;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepo recipeRepo;

    public Map<String, Long> saveRecipe(@Valid Recipe recipe) {
//        for (Directions direction: recipe.getDirections()) {
//            direction.setRecipe(recipe);
//        }
//        for (Ingredients ingredient: recipe.getIngredients()) {
//            ingredient.setRecipe(recipe);
//        }
        Hibernate.initialize(recipe);
        System.out.println(recipe.toString());
        Recipe addedRecipe = recipeRepo.save(recipe);
        return Map.of("id", addedRecipe.getId());
    }

    public Recipe getRecipe(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
        return optionalRecipe.orElse(null);
    }

    public boolean deleteRecipe(Long id) {
        if (!recipeRepo.existsById(id)) {
            return false;
        }
        recipeRepo.deleteById(id);
        return true;
    }
}
