package com.Reppond.Recipe;

public class HtmlFormatter {
	
	public static String formatRecipe(Recipe recipe) {
        StringBuilder response = new StringBuilder();
        response.append("<h2>").append(recipe.getTitle()).append("</h2>");
        response.append("<p><strong>Cooking Minutes:</strong> ").append(recipe.getCookingMinutes()).append("</p>");
        response.append("<p><strong>Dairy Free:</strong> ").append(recipe.getDairyFree()).append("</p>");
        response.append("<p><strong>Gluten Free:</strong> ").append(recipe.getGlutenFree()).append("</p>");
        response.append("<p><strong>Instructions:</strong> ").append(recipe.getInstructions()).append("</p>");
        response.append("<p><strong>Preparation Minutes:</strong> ").append(recipe.getPreparationMinutes()).append("</p>");
        response.append("<p><strong>Price Per Serving:</strong> ").append(recipe.getPricePerServing()).append("</p>");
        response.append("<p><strong>Ready In Minutes:</strong> ").append(recipe.getReadyInMinutes()).append("</p>");
        response.append("<p><strong>Servings:</strong> ").append(recipe.getServings()).append("</p>");
        response.append("<p><strong>Spoonacular Score:</strong> ").append(recipe.getSpoonacularScore()).append("</p>");
        response.append("<p><strong>Vegan:</strong> ").append(recipe.getVegan()).append("</p>");
        response.append("<p><strong>Vegetarian:</strong> ").append(recipe.getVegetarian()).append("</p>");
        response.append("<hr>");
        return response.toString();
    }
}

