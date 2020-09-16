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

	/**
	 * Gathers provinces from definition.csv and returns a HashMap of the info
	 * @param provincesList the file to collect information from
	 * @return a HashMap of the information
	 */
	public static Map<Color, Province> loadProvinces(String provincesList) {
		
		//TODO: check to see if file is definition.csv
		
		HashMap<Color, Province> provinces = new HashMap<Color, Province>();
		
		// load provinces from definition.csv and put info into HashMap
		try {
			File file = new File(provincesList);
			Scanner scanner = new Scanner(file);
			StringBuilder line;
			
			int provincesNumber = 0;
			// get information from each line
			while (scanner.hasNextLine()) {
				line = new StringBuilder(scanner.nextLine());
				Province prov = new Province();
				int index = line.indexOf(";");
				
				// comment
				if (line.charAt(0) == '#') {
					continue;
				}
				
				prov.setNumber( Integer.parseInt(line.substring(0, index)) );
				line.delete(0, index + 1);
				
				// get RGB value
				int r, g, b;
				index = line.indexOf(";");
                r = Integer.parseInt(line.substring(0, index));
                line.delete(0, index + 1);
                index = line.indexOf(";");
                g = Integer.parseInt(line.substring(0, index));
                line.delete(0, index + 1);
                index = line.indexOf(";");
                b = Integer.parseInt(line.substring(0, index));
                line.delete(0, index + 1);
                Color color = new Color(r, g, b);
                prov.setColor(color);

                // get name
                index = line.indexOf(";");
                prov.setName(line.substring(0, index));
                line.delete(0, index + 1);

                // placeholder province
                if (prov.getName().equals("x"))
                {
                    continue;
                }

                // add to hashmap
                provinces.put(color, prov);
                provincesNumber++;
                
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Provinces successfully loaded");
			alert.setContentText(provincesNumber + " provinces were loaded.");
			alert.show();
			
			scanner.close();
			
		// error handling
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load file");
			alert.setContentText("File " + provincesList + " could not be found.");
			alert.show();
			e.printStackTrace();
		} 
		
		return provinces;
	}
	
}
