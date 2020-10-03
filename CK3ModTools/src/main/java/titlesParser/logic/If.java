package titlesParser.logic;

import java.util.ArrayList;
import java.util.List;

public class If {

    private Limit limit;
    private List<String> add;

    public If() {
        add = new ArrayList<>();
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public List<String> getAdd() {
        return add;
    }

    public void addAdd(String add) {
        this.add.add(add);
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + "if = {\n");

        if (limit != null) {
            builder.append(limit.print(offset + "\t"));
        }

        if (add != null) {
            for (var a : add) {
                builder.append(offset + "\t" + "add = " + a + "\n");
            }
        }

        builder.append(offset + "}\n");
        return builder.toString();
    }

}
