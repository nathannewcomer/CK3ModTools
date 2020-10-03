package titlesParser.titles;

import java.util.ArrayList;
import java.util.List;

public class Duchy extends Title {

    private List<County> counties;
    private List<Barony> baronies;

    public Duchy() {
        counties = new ArrayList<>();
        baronies = new ArrayList<>();
    }

    public List<County> getCounties() {
        return counties;
    }

    public List<Barony> getBaronies() {
        return baronies;
    }

    public void addCounty(County county) {
        this.counties.add(county);
    }

    public void addBarony(Barony barony) {
        this.baronies.add(barony);
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + this.name + " = {\n");

        builder.append(printAttributes(offset + "\t"));

        for (var barony : baronies) {
            builder.append(barony.print(offset + "\t"));
        }

        for (var county : counties) {
            builder.append(county.print(offset +  "\t"));
        }

        builder.append(offset + "}\n");
        return builder.toString();
    }

}
