package CK3ModTools.titles;

import CK3ModTools.titles.Barony;

import java.awt.*;
import java.util.ArrayList;

public class County {

    private Color color;
    private Color color2;
    private ArrayList<Barony> baronies;

    public County() {

    }

    public ArrayList<Barony> getBaronies() {
        return baronies;
    }

    public void setBaronies(ArrayList<Barony> baronies) {
        this.baronies = baronies;
    }

}
