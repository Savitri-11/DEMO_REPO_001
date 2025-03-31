package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class JsonUtils {

	public static Map<String, String> readJson(String filePath) {
		
		try {
			FileReader reader = new FileReader("/Users/savitrigajakosh/Documents/Generic_Selenium_Framework/src/main/resources//"+ filePath);
			Type type = new TypeToken<Map<String, String>>() {
			}.getType();
			return new Gson().fromJson(reader, type);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read JSON file: " + e.getMessage());
		}
	}
}