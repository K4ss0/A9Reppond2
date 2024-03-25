package com.Reppond.Recipe;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeParser {

	private static final String FILE_PATH = "recipes.txt";

	public static List<Recipe> parseRecipes() {
		List<Recipe> recipesList = new ArrayList<>();

		try (FileReader input = new FileReader(FILE_PATH);
				CSVParser parser = CSVFormat.DEFAULT.withHeader().withIgnoreSurroundingSpaces().withEscape('\\').parse(input)) {
			
			System.out.println("Headers:");
            for (String header : parser.getHeaderMap().keySet()) {
                System.out.println(header);
            }
            System.out.println();
            
            for (CSVRecord record : parser) {
                System.out.println("Record:");
                for (String header : parser.getHeaderMap().keySet()) {
                    System.out.println(header + ": " + record.get(header));
                }
				Recipe recipe = new Recipe();
				recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
				recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
				recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
				recipe.setInstructions(record.get("Instructions"));
				recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
				recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
				recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
				recipe.setServings(Integer.parseInt(record.get("Servings")));
				recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
				recipe.setTitle(record.get("Title"));
				recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
				recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

				recipesList.add(recipe);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return recipesList;
	}
}