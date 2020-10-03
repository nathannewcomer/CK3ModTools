package titlesParser.logic;

public class TriggerIf {

    private Limit limit;
    private Faith faith;
    private String hasCultureGroup;
    private Or or;
    private Not not;
    private String culture;

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public Faith getFaith() {
        return faith;
    }

    public void setFaith(Faith faith) {
        this.faith = faith;
    }

    public String getHasCultureGroup() {
        return hasCultureGroup;
    }

    public void setHasCultureGroup(String hasCultureGroup) {
        this.hasCultureGroup = hasCultureGroup;
    }

    public Or getOr() {
        return or;
    }

    public void setOr(Or or) {
        this.or = or;
    }

    public Not getNot() {
        return not;
    }

    public void setNot(Not not) {
        this.not = not;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + "trigger_if = {\n");

        if (limit != null) {
            builder.append(limit.print(offset + "\t"));
        }
        if (faith != null) {
            builder.append(faith.print(offset + "\t"));
        }
        if (hasCultureGroup != null) {
            builder.append(offset + "\t" + "has_culture_group = " + hasCultureGroup + "\n");
        }
        if (or != null) {
            builder.append(or.print(offset + "\t"));
        }
        if (not != null) {
            builder.append(not.print(offset + "\t"));
        }
        if (culture != null) {
            builder.append(offset + "culture = " + culture + "\n");
        }

        builder.append(offset + "}\n");
        return builder.toString();
    }

}
