package titlesParser.titles;

import java.util.ArrayList;
import java.util.List;

public class Empire extends Title {

    private List<Kingdom> kingdoms;
    private List<Duchy> duchies;
    private List<County> counties;
    private List<Barony> baronies;

    public Empire() {
        kingdoms = new ArrayList<>();
        duchies = new ArrayList<>();
        counties = new ArrayList<>();
        baronies = new ArrayList<>();
    }

    public List<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public List<Duchy> getDuchies() {
        return duchies;
    }

    public List<County> getCounties() {
        return counties;
    }

    public List<Barony> getBaronies() {
        return baronies;
    }

    public void addKingdom(Kingdom kingdom) {
        kingdoms.add(kingdom);
    }

    public void addDuchy(Duchy duchy) {
        duchies.add(duchy);
    }

    public void addCounty(County county) {
        counties.add(county);
    }

    public void addBarony(Barony barony) {
        baronies.add(barony);
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + this.name + " = {\n");

        builder.append(printAttributes(offset +  "\t"));

        for (var barony : baronies) {
            builder.append(barony.print(offset +  "\t"));
        }

        for (var county : counties) {
            builder.append(county.print(offset +  "\t"));
        }

        for (var duchy : duchies) {
            builder.append(duchy.print(offset +  "\t"));
        }

         for (var kingdom : kingdoms) {
             builder.append(kingdom.print(offset + "\t"));
         }

        builder.append(offset + "}\n");
        return builder.toString();
    }
}
