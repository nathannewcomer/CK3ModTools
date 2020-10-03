package titlesParser.logic;

public class Limit {

    private boolean isAI;
    private Not not;
    private String cultureGroup;
    private String culture;
    private Or or;
    private String faith;

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public Not getNot() {
        return not;
    }

    public void setNot(Not not) {
        this.not = not;
    }

    public String getCultureGroup() {
        return cultureGroup;
    }

    public void setCultureGroup(String cultureGroup) {
        this.cultureGroup = cultureGroup;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public Or getOr() {
        return or;
    }

    public void setOr(Or or) {
        this.or = or;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();

        builder.append(offset + "limit = {\n");

        if (isAI) {
            builder.append(offset + "\t" + "is_ai = yes\n");
        }
        if (not != null) {
            builder.append(not.print(offset + "\t"));
        }
        if (cultureGroup != null) {
            builder.append(offset + "\t" + "culture_group = " + cultureGroup + "\n");
        }
        if (culture != null) {
            builder.append(offset + "\t" + "culture = " + cultureGroup + "\n");
        }
        if (or != null) {
            builder.append(or.print(offset + "\t"));
        }
        if (faith != null) {
            builder.append(offset + "\t" + "faith = " + faith + "\n");
        }

        builder.append(offset + "}\n");

        return builder.toString();
    }

}
