package com.Reppond.Recipe;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class RecipeParser {

    private static final String FILE_PATH = "recipes.txt";
    private static List<Recipe> recipesList;

    static {
        recipesList = parseRecipes();
    }

    private static List<Recipe> parseRecipes() {
        List<Recipe> list = new ArrayList<>();

        try (CSVParser parser = new CSVParser(new FileReader(FILE_PATH), CSVFormat.EXCEL.withSkipHeaderRecord(true).withHeader())) {
            for (CSVRecord record : parser) {
                Recipe recipe = new Recipe(
                        Integer.parseInt(record.get("Cooking Minutes")),
                        Boolean.parseBoolean(record.get("Dairy Free")),
                        Boolean.parseBoolean(record.get("Gluten Free")),
                        record.get("Instructions"),
                        Double.parseDouble(record.get("Preparation Minutes")),
                        Double.parseDouble(record.get("Price Per Serving")),
                        Integer.parseInt(record.get("Ready In Minutes")),
                        Integer.parseInt(record.get("Servings")),
                        Double.parseDouble(record.get("Spoonacular Score")),
                        record.get("Title"),
                        Boolean.parseBoolean(record.get("Vegan")),
                        Boolean.parseBoolean(record.get("Vegetarian"))
                );
                list.add(recipe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Recipe> getRecipesList() {
        return recipesList;
    }
}
