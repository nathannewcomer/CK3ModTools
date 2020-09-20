package CK3ModTools;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileHandler {

	// this is the only method that gets called outside the class
	public static Map<Color, Province> loadProvinces(String directory) {
		
		HashMap<Integer, Province> provinces = new HashMap<>();
		
		// load provinces from definition.csv and put info into HashMap
		try {
			loadDefinition(provinces, directory);

			/*Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Provinces successfully loaded");
			alert.setContentText(provinces.size() + " provinces were loaded.");
			alert.show();*/
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not find file");
			alert.setContentText("definition.csv could not be found.");
			alert.show();
			e.printStackTrace();
		}

		try {
			loadClimate(provinces, directory);
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not find file");
			alert.setContentText("climate.txt could not be found.");
			alert.show();
			e.printStackTrace();
		}

		try {
			loadProvinceTerrain(provinces, directory);
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not find file");
			alert.setContentText("00_province_terrain.txt could not be found.");
			alert.show();
			e.printStackTrace();
		}

		// convert our hashmap to a better one for searching using color
		Map<Color, Province> output = new HashMap<>();

		for (Province prov : provinces.values()) {
			output.put(prov.getColor(), prov);
		}

		return output;
	}

	// load definition.csv
	private static void loadDefinition(Map<Integer, Province> provinces, String directory) throws FileNotFoundException {

			File file = new File(directory + "\\map_data\\definition.csv");
			Scanner scanner = new Scanner(file);
			String line;

			// get information from each line
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();

				// skip province 0
				if (line.charAt(0) == '0' || line.charAt(0) == '#') {
					continue;
				}
				String[] values = line.split(";");
				Province prov = new Province();

				// set values
				prov.setId(Integer.parseInt(values[0]));
				int r, g, b;
				r = Integer.parseInt(values[1]);
				g = Integer.parseInt(values[2]);
				b = Integer.parseInt(values[3]);
				prov.setColor(new Color(r, g, b));
				prov.setName(values[4]);

				provinces.put(prov.getId(), prov);

			}
			scanner.close();
	}

	// load climate.txt
	private static void loadClimate(Map<Integer, Province> provinces, String directory) throws FileNotFoundException {

		File file = new File(directory + "\\map_data\\climate.txt");
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\s|#.+|=|\\{|}");	// removes all spaces, commented lines, equals, and curly braces
		String token;
		Climate climate = null;
		HashMap<Integer, Climate> provClimates = new HashMap<>();


		while (scanner.hasNext()) {
			token = scanner.next();

			// sometimes the scanner gives empty strings
			if (token.length() < 1) {
				continue;
			}

			if (!Character.isDigit(token.charAt(0))) {					// set climate
				climate = Climate.valueOf(token.toUpperCase());
			} else {
				provClimates.put(Integer.parseInt(token), climate);		// add climate to province
			}
		}

		scanner.close();

		// add climates to hash map
		for (Map.Entry<Integer, Climate> entry : provClimates.entrySet()) {
			provinces.get(entry.getKey()).setClimate(entry.getValue());
		}
	}

	// load province_terrain.txt from common folder
	private static void loadProvinceTerrain(Map<Integer, Province> provinces, String directory) throws FileNotFoundException {
		File file = new File(directory + "\\common\\province_terrain\\00_province_terrain.txt");
		Scanner scanner = new Scanner(file);
		String line;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();

			// first character should be a digit
			if (line.length() < 1 || !Character.isDigit(line.charAt(0))) {
				continue;
			}

			// set terrain to value
			String[] values = line.split("=|\\s");
			int id = Integer.parseInt(values[0]);
			provinces.get(id).setTerrain(Terrain.valueOf(values[1].toUpperCase()));
		}
	}
}
	

