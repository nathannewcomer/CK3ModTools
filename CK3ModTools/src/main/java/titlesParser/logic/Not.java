package titlesParser.logic;

public class Not {

    private String culture;
    private String hasTitle;
    private String exists;
    private Faith faith;

    public Faith getFaith() {
        return faith;
    }

    public void setFaith(Faith faith) {
        this.faith = faith;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getHasTitle() {
        return hasTitle;
    }

    public void setHasTitle(String hasTitle) {
        this.hasTitle = hasTitle;
    }

    public String getExists() {
        return exists;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();

        builder.append(offset + "NOT = {\n");

        if (culture != null) {
            builder.append(offset + "\t" + "culture = " + culture + "\n");
        }
        if (hasTitle != null) {
            builder.append(offset + "\t" + "has_title = " + hasTitle + "\n");
        }
        if (exists != null) {
            builder.append(offset + "\t" + "exists = " + exists + "\n");
        }

        builder.append(offset + "}\n");

        return builder.toString();
    }

}
