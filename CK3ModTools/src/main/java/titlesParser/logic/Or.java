package titlesParser.logic;

import java.util.ArrayList;
import java.util.List;

public class Or {

    private List<String> cultureGroup = new ArrayList<>();
    private List<String> culture = new ArrayList<>();

    public List<String> getCultureGroup() {
        return cultureGroup;
    }

    public void setCultureGroup(List<String> cultureGroup) {
        this.cultureGroup = cultureGroup;
    }

    public List<String> getCulture() {
        return culture;
    }

    public void setCulture(List<String> culture) {
        this.culture = culture;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();

        builder.append(offset + "OR = {\n");

        for (var group : cultureGroup) {
            builder.append(offset + "\t" + "culture_group = " + group + "\n");
        }

        for (var c : culture) {
            builder.append(offset + "\t" + "culture = " + c + "\n");
        }

        builder.append(offset + "}\n");

        return builder.toString();
    }

}
