package CK3ModTools.titles;

import CK3ModTools.parser.FileScanner;

import java.awt.*;
import java.util.ArrayList;

public class Empire {

    private Color color;
    private Color color2;
    private County capital;

    // according to paradox, each level is optional,
    // but duchies and below will usually be empty for empires
    private ArrayList<Kingdom> kingdoms;
    private ArrayList<Duchy> duchies;
    private ArrayList<County> counties;
    private ArrayList<Barony> baronies;

    public Empire() {
        // TODO: maybe have more constructors
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public County getCapital() {
        return capital;
    }

    public void setCapital(County capital) {
        this.capital = capital;
    }

    public ArrayList<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public void setKingdoms(ArrayList<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public ArrayList<Duchy> getDuchies() {
        return duchies;
    }

    public void setDuchies(ArrayList<Duchy> duchies) {
        this.duchies = duchies;
    }

    public ArrayList<County> getCounties() {
        return counties;
    }

    public void setCounties(ArrayList<County> counties) {
        this.counties = counties;
    }

    public ArrayList<Barony> getBaronies() {
        return baronies;
    }

    public void setBaronies(ArrayList<Barony> baronies) {
        this.baronies = baronies;
    }

}
