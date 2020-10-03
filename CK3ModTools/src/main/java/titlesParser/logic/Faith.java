package titlesParser.logic;

public class Faith {

    private String religionTag;
    private String hasDoctrine;

    public String getReligionTag() {
        return religionTag;
    }

    public void setReligionTag(String religionTag) {
        this.religionTag = religionTag;
    }

    public String getHasDoctrine() {
        return hasDoctrine;
    }

    public void setHasDoctrine(String hasDoctrine) {
        this.hasDoctrine = hasDoctrine;
    }

    public String print(String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append(offset + "faith = { \n");

       if (religionTag != null) {
            builder.append(offset + "\treligion_tag = " + religionTag + "\n");
        }
       if (hasDoctrine != null) {
           builder.append(offset + "\thas_doctrine = " + hasDoctrine + "\n");
       }

        builder.append(offset + "}\n");

        return builder.toString();
    }
}
