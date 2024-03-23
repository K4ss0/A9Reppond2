package com.Reppond.Recipe;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeParser {

    private static final String FILE_PATH = "recipes.txt";

    public static List<Map<String, String>> getRecipesList() {
        List<Map<String, String>> recipesList = new ArrayList<>();

        try (FileReader input = new FileReader(FILE_PATH);
             CSVParser parser = CSVFormat.EXCEL.withHeader().parse(input)) {

        	System.out.println("Headers:");
            for (String header : parser.getHeaderMap().keySet()) {
                System.out.println(header);
            }
            System.out.println();


            for (CSVRecord record : parser) {
                Map<String, String> recipeMap = new HashMap<>();
                for (String header : parser.getHeaderMap().keySet()) {
                    recipeMap.put(header, record.get(header));
                }
                recipesList.add(recipeMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipesList;
    }
}
