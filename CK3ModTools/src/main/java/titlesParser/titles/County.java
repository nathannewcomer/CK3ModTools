package titlesParser.titles;

import java.util.ArrayList;
import java.util.List;

public class County extends Title {

    private List<Barony> baronies;

    public County() {
        baronies = new ArrayList<>();
    }

    public List<Barony> getBaronies() {
        return this.baronies;
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

        builder.append(offset + "}\n");
        return builder.toString();
    }

}
