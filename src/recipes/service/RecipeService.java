package recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.Recipe;
import recipes.model.UserDetailsImpl;
import recipes.repository.RecipeRepo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepo recipeRepo;

    public Map<String, Long> saveRecipe(Recipe recipe) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        recipe.setAutorId(userDetails.getId());
        recipe.setDate(LocalDateTime.now().toString());
        Recipe addedRecipe = recipeRepo.save(recipe);
        return Map.of("id", addedRecipe.getId());
    }

    public Recipe getRecipe(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
        if (optionalRecipe.isPresent()) {
            return optionalRecipe.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteRecipe(Long id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!Objects.equals(recipe.getAutorId(), userDetails.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipeRepo.deleteById(id);
    }

    public void updateRecipe(Long id, Recipe recipe) {
        Recipe savedRecipe = getRecipe(id);
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!Objects.equals(savedRecipe.getAutorId(), userDetails.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        savedRecipe.setName(recipe.getName());
        savedRecipe.setCategory(recipe.getCategory());
        savedRecipe.setDescription(recipe.getDescription());
        savedRecipe.setIngredients(recipe.getIngredients());
        savedRecipe.setDirections(recipe.getDirections());
        savedRecipe.setDate(LocalDateTime.now().toString());
        recipeRepo.save(savedRecipe);
    }

    public List<Recipe> searchRecipe(String category, String name) {
        if ((category == null && name == null) ^ (category != null && name != null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (name != null) {
            return recipeRepo.findDistinctByNameContainingIgnoreCaseOrderByDateDesc(name);
        } else {
            return recipeRepo.findDistinctByCategoryIgnoreCaseOrderByDateDesc(category);
        }
    }
}
