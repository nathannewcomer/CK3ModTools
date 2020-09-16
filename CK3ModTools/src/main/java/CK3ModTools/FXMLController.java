package CK3ModTools;

import java.awt.Color;
import java.io.File;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

public class FXMLController {

    @FXML private Label color;
    @FXML private Label name;
    @FXML private MenuBar menuBar;
    @FXML private Tab map;
    @FXML private Tab common;
    @FXML private Tab history;
    @FXML private ComboBox<String> climateCombo;
    @FXML private ComboBox<String> terrainCombo;
    @FXML private ImageView provincesImage;
    @FXML private ScrollPane scrollPane;
    
    private File rootDirectory;
    private Map<Color, Province> provinces;

    public void initialize() {
    	// add items to combo boxes
    	for (Climate climate : Climate.values()) {
    		climateCombo.getItems().add(climate.toString());
    	}
    	for (Terrain terrain : Terrain.values()) {
    		terrainCombo.getItems().add(terrain.toString());
    	}
    }
    
    @FXML
    private void openFolder(ActionEvent event) {
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	rootDirectory = directoryChooser.showDialog(menuBar.getScene().getWindow());
    	
    	Image image = new Image(rootDirectory.toURI().toString() + "map_data/provinces.png");
    	provincesImage.setImage(image);
    	
    	//TODO: have this run on a new thread
    	provinces = FileHandler.loadProvinces(rootDirectory.getPath() + "\\map_data\\definition.csv");
    }
    
    // only used to disable left click (and middle mouse) for scrolling
    @FXML
    private void disableLeftScroll(MouseEvent event) {
    	if (event.getButton() != MouseButton.SECONDARY) {
    		event.consume();
    		scrollPane.getScene().setCursor(Cursor.DEFAULT);
    	}
    }
    
    @FXML
    private void getProvince(MouseEvent event) {
    	
    	// only do this on left click
    	if (event.getButton() != MouseButton.PRIMARY) {
    		return;
    	}
    	
    	// get color
    	PixelReader reader = provincesImage.getImage().getPixelReader();
    	int argb = reader.getArgb((int)event.getX(), (int)event.getY());
    	
    	int b = argb & 0xff;
    	int g = (argb >> 8) & 0xff;
    	int r = (argb >> 16) & 0xff;
    	
    	Color provColor = new Color(r, g, b);
    	
    	// get province and display info
    	if (provinces.containsKey(provColor)) {
    		Province province = provinces.get(provColor); 
    		color.setText("R: " + provColor.getRed() + " G: " + provColor.getGreen() + " B: " + provColor.getBlue());
    		name.setText(province.getName());
    		
    		//climateCombo.setValue(province.getClimate().toString());
    		//terrainCombo.setValue(value);
    	} else {
    		color.setText("Could not find province");
    	}
    }
    
}