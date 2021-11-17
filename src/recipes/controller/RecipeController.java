package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.model.Recipe;
import recipes.service.RecipeService;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/recipe")
class RecipeRestController {

    @Autowired
    RecipeService recipeBook;

    @PostMapping(path = "/new")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> add(@Valid @RequestBody Recipe recipe) {
        return recipeBook.saveRecipe(recipe);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recipe retrieve(@PathVariable Long id) {
        return recipeBook.getRecipe(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recipeBook.deleteRecipe(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestBody Recipe recipe) {
        recipeBook.updateRecipe(id, recipe);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Recipe> search(@RequestParam(required = false) String category,
                               @RequestParam(required = false) String name) {
        return recipeBook.searchRecipe(category, name);
    }
}
