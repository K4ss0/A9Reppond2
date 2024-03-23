package com.Reppond.Recipe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

	@GetMapping("/all-recipes")
	public String getAllRecipes() {
	    List<Map<String, String>> recipes = RecipeParser.getRecipesList();
	    StringBuilder response = new StringBuilder();
	    for (Map<String, String> recipeMap : recipes) {
	        response.append("Recipe:\n");
	        for (Map.Entry<String, String> entry : recipeMap.entrySet()) {
	            response.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
	        }
	        response.append("\n");
	    }
	    return response.toString();
	}
	
	@GetMapping("/gluten-free")
	public String getGlutenFreeRecipes() {
	    List<Map<String, String>> recipes = RecipeParser.getRecipesList();
	    StringBuilder response = new StringBuilder();
	    for (Map<String, String> recipeMap : recipes) {
	        if (Boolean.parseBoolean(recipeMap.get("Gluten Free"))) {
	            appendRecipeInfo(recipeMap, response);
	        }
	    }
	    return response.toString();
	}

	@GetMapping("/vegan")
	public String getVeganRecipes() {
	    List<Map<String, String>> recipes = RecipeParser.getRecipesList();
	    StringBuilder response = new StringBuilder();
	    for (Map<String, String> recipeMap : recipes) {
	    	System.out.println("Vegan Value: " + recipeMap.get("Vegan"));
	        if (Boolean.parseBoolean(recipeMap.get("Vegan"))) {
	            appendRecipeInfo(recipeMap, response);
	        }
	    }
	    return response.toString();
	}

	@GetMapping("/vegan-and-gluten-free")
	public String getVeganAndGlutenFreeRecipes() {
	    List<Map<String, String>> recipes = RecipeParser.getRecipesList();
	    StringBuilder response = new StringBuilder();
	    for (Map<String, String> recipeMap : recipes) {
	        if (Boolean.parseBoolean(recipeMap.get("Vegan")) && Boolean.parseBoolean(recipeMap.get("Gluten Free"))) {
	            appendRecipeInfo(recipeMap, response);
	        }
	    }
	    return response.toString();
	}

	@GetMapping("/vegetarian")
	public String getVegetarianRecipes() {
	    List<Map<String, String>> recipes = RecipeParser.getRecipesList();
	    StringBuilder response = new StringBuilder();
	    for (Map<String, String> recipeMap : recipes) {
	        if (Boolean.parseBoolean(recipeMap.get("Vegetarian"))) {
	            appendRecipeInfo(recipeMap, response);
	        }
	    }
	    return response.toString();
	}

	private void appendRecipeInfo(Map<String, String> recipeMap, StringBuilder response) {
	    response.append("Title: ").append(recipeMap.get("Title")).append("\n")
	            .append("Instructions: ").append(recipeMap.get("Instructions")).append("\n\n");
	}

}