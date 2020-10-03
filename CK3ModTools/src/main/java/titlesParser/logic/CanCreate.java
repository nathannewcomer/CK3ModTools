package titlesParser.logic;

public class CanCreate {

    private boolean always;         // this seems to only be used for k_old_armenia
    private TriggerIf triggerIf;
    private Not not;
    Faith faith;

    public boolean isAlways() {
        return always;
    }

    public void setAlways(boolean always) {
        this.always = always;
    }

    public TriggerIf getTriggerIf() {
        return triggerIf;
    }

    public void setTriggerIf(TriggerIf triggerIf) {
        this.triggerIf = triggerIf;
    }

    public void setNot(Not not) {
        this.not = not;
    }

    public Not getNot() {
        return not;
    }

    public Faith getFaith() {
        return faith;
    }

    public void setFaith(Faith faith) {
        this.faith = faith;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();

        builder.append(offset + "can_create = {\n");

        if (not != null) {
            builder.append(not.print(offset));
        }
        if (triggerIf != null) {
            builder.append(triggerIf.print(offset + "\t"));
        }
        if (always) {
            builder.append(offset + "always = yes\n");
        }
        if (faith != null) {
            builder.append(faith.print(offset + "\t"));
        }

        builder.append(offset + "}\n");

        return builder.toString();
    }

}
