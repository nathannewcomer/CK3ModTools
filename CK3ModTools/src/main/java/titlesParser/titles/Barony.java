package titlesParser.titles;

public class Barony extends Title {
    
    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + this.name + " = {\n");

        builder.append(printAttributes(offset + "\t"));

        builder.append(offset + "}\n");
        return builder.toString();
    }

}
