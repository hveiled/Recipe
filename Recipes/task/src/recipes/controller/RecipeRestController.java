package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.Recipe;
import recipes.service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeRestController {

    @Autowired
    RecipeService recipeBook;

    @PostMapping(path = "/new")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> add(@RequestBody @Autowired Recipe recipe) {
        return recipeBook.saveRecipe(recipe);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recipe retrieve(@PathVariable Long id) {
        Recipe recipe = recipeBook.getRecipe(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return recipe;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!recipeBook.deleteRecipe(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No content");
        }
    }
}
