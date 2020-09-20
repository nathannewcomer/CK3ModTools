package CK3ModTools;

import java.awt.Color;
import java.util.List;

public class Province {

	private int id;
    private Color color;
    private String name;
    private Climate climate;
    private List<Integer> adjacencies;
    // position potentially to be implemented
    private Terrain terrain;
    
    public Province() {
    	setId(-1);
    	setColor(null);
    	setName("undefined");
    	climate = Climate.NO_WINTER;
    	adjacencies = null;
    	terrain = Terrain.PLAINS;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Climate getClimate() {
		return this.climate;
	}
	
	public void setClimate(Climate climate) {
		this.climate = climate;
	}
	
	public void addAdjacency(int provinceNumber) {
		adjacencies.add(provinceNumber);
	}
    
	public Terrain getTerrain() {
		return this.terrain;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	//TODO: add formatting methods to make files
	
}
