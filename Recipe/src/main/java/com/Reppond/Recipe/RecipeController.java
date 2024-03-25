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

	    response.append("<html><body>");
	    response.append("<h1>All Recipes</h1>");

	    for (Recipe recipe : recipes) {
	        response.append(HtmlFormatter.formatRecipe(recipe));
	    }

	    response.append("</body></html>");

	    return response.toString();
	}

	@GetMapping("/vegan-recipes")
	public String getVeganRecipes() {
	    List<Recipe> recipes = RecipeParser.parseRecipes();
	    StringBuilder response = new StringBuilder();

	    response.append("<html><body>");
	    response.append("<h1>Vegan Recipes</h1>");

	    for (Recipe recipe : recipes) {
	        if (recipe.getVegan()) {
	            response.append(HtmlFormatter.formatRecipe(recipe));
	        }
	    }

	    response.append("</body></html>");

	    return response.toString();
	}
	@GetMapping("/vegetarian-recipes")
	public String getVegetarianRecipes() {
	    List<Recipe> recipes = RecipeParser.parseRecipes();
	    StringBuilder response = new StringBuilder();

	    response.append("<html><body>");
	    response.append("<h1>Vegetarian Recipes</h1>");

	    for (Recipe recipe : recipes) {
	        if (recipe.getVegan()) {
	            response.append(HtmlFormatter.formatRecipe(recipe));
	        }
	    }

	    response.append("</body></html>");

	    return response.toString();
	}
	@GetMapping("/gluten-free-recipes")
	public String getGlutenFreeRecipes() {
	    List<Recipe> recipes = RecipeParser.parseRecipes();
	    StringBuilder response = new StringBuilder();

	    response.append("<html><body>");
	    response.append("<h1>Gluten-Free Recipes</h1>");

	    for (Recipe recipe : recipes) {
	        if (recipe.getVegan()) {
	            response.append(HtmlFormatter.formatRecipe(recipe));
	        }
	    }

	    response.append("</body></html>");

	    return response.toString();
	}
	@GetMapping("/vegan-gluten-free-recipes")
	public String getVeganAndGlutenFreeRecipes() {
	    List<Recipe> recipes = RecipeParser.parseRecipes();
	    StringBuilder response = new StringBuilder();

	    response.append("<html><body>");
	    response.append("<h1>Vegan and Gluten-Free Recipes</h1>");

	    for (Recipe recipe : recipes) {
	        if (recipe.getVegan() && recipe.getGlutenFree()) {
	            response.append(HtmlFormatter.formatRecipe(recipe));
	        }
	    }

	    response.append("</body></html>");

	    return response.toString();
	}
}