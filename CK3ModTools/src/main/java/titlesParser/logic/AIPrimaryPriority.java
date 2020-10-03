package titlesParser.logic;

import java.util.ArrayList;
import java.util.List;

public class AIPrimaryPriority {

    private List<If> ifs;
    private String add;

    public AIPrimaryPriority() {
        ifs = new ArrayList<>();
    }

    public List<If> getIfs() {
        return ifs;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void addIf(If ifstmt) {
        ifs.add(ifstmt);
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + "ai_primary_priority = {\n");

        if (!ifs.isEmpty()) {
            for (var item : ifs) {
                builder.append(item.print(offset + "\t"));
            }
        }

        if (add != null) {
            builder.append(offset + "\t" + "add = " + add + "\n");
        }

        builder.append(offset + "}\n");
        return builder.toString();
    }
}
