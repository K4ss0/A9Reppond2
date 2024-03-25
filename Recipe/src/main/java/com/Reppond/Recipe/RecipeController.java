package com.Reppond.Recipe;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

	 @GetMapping("/all-recipes")
	    public String getAllRecipes() {
	        List<Recipe> recipes = RecipeParser.parseRecipes();
	        StringBuilder response = new StringBuilder();

	        for (Recipe recipe : recipes) {
	            response.append("Cooking Minutes: ").append(recipe.getCookingMinutes()).append("\n");
	            response.append("Dairy Free: ").append(recipe.getDairyFree()).append("\n");
	            response.append("Gluten Free: ").append(recipe.getGlutenFree()).append("\n");
	            response.append("Instructions: ").append(recipe.getInstructions()).append("\n");
	            response.append("Preparation Minutes: ").append(recipe.getPreparationMinutes()).append("\n");
	            response.append("Price Per Serving: ").append(recipe.getPricePerServing()).append("\n");
	            response.append("Ready In Minutes: ").append(recipe.getReadyInMinutes()).append("\n");
	            response.append("Servings: ").append(recipe.getServings()).append("\n");
	            response.append("Spoonacular Score: ").append(recipe.getSpoonacularScore()).append("\n");
	            response.append("Title: ").append(recipe.getTitle()).append("\n");
	            response.append("Vegan: ").append(recipe.getVegan()).append("\n");
	            response.append("Vegetarian: ").append(recipe.getVegetarian()).append("\n\n");
	        }

	        return response.toString();
	    }
	}