package com.Reppond.Recipe;

import java.util.List;
//import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

//    @GetMapping("/gluten-free")
//    public List<Recipe> getGlutenFreeRecipes() {
//        List<Recipe> allRecipes = RecipeParser.getRecipesList();
//        return allRecipes.stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
//    }
//
//    @GetMapping("/vegan")
//    public List<Recipe> getVeganRecipes() {
//        List<Recipe> allRecipes = RecipeParser.getRecipesList();
//        return allRecipes.stream().filter(Recipe::getVegan).collect(Collectors.toList());
//    }
//
//    @GetMapping("/vegan-and-gluten-free")
//    public List<Recipe> getVeganAndGlutenFreeRecipes() {
//        List<Recipe> allRecipes = RecipeParser.getRecipesList();
//        return allRecipes.stream().filter(recipe -> recipe.getVegan() && recipe.getGlutenFree()).collect(Collectors.toList());
//    }
//
//    @GetMapping("/vegetarian")
//    public List<Recipe> getVegetarianRecipes() {
//        List<Recipe> allRecipes = RecipeParser.getRecipesList();
//        return allRecipes.stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
//    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return RecipeParser.getRecipesList();
    }
}
