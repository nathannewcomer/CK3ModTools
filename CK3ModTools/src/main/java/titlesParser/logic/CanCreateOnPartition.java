package titlesParser.logic;

// only used by k_jerusalem
public class CanCreateOnPartition {

    private Faith faith;

    public Faith getFaith() {
        return faith;
    }

    public void setFaith(Faith faith) {
        this.faith = faith;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();

        builder.append(offset + "can_create_on_partition = {\n");
        builder.append(faith.print(offset + "\t"));
        builder.append(offset + "}\n");

        return builder.toString();
    }
}
