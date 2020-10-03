package titlesParser.titles;

import titlesParser.logic.AIPrimaryPriority;
import titlesParser.logic.CanCreate;
import titlesParser.logic.CanCreateOnPartition;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public abstract class Title {

    // not all fields will be used in titles
    // e.g. empires don't use province
    // this means check for null!
    String name;
    int province = 0;
    Color color;
    Color color2;
    boolean definiteForm;
    String capital;
    boolean rulerUsesTitleName = true;
    boolean landless = false;
    boolean noAutomaticClaims = false;
    boolean alwaysFollowsPrimaryHeir = false;
    boolean destroyIfInvalidHeir = false;
    boolean dejureDriftDisabled = false;
    boolean canBeNamedAfterDynasty = true;
    AIPrimaryPriority aiPrimaryPriority;
    CanCreate canCreate;
    CanCreateOnPartition canCreateOnPartition;
    HashMap<String, String> culturalNames;
    List<String> maleNames;

    public CanCreate getCanCreate() {
        return this.canCreate;
    }

    public void setCanCreate(CanCreate canCreate) {
        this.canCreate = canCreate;
    }

    public CanCreateOnPartition getCanCreateOnPartition() {
        return canCreateOnPartition;
    }

    public void setCanCreateOnPartition(CanCreateOnPartition canCreateOnPartition) {
        this.canCreateOnPartition = canCreateOnPartition;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public boolean isDefiniteForm() {
        return definiteForm;
    }

    public void setDefiniteForm(boolean definiteForm) {
        this.definiteForm = definiteForm;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isRulerUsesTitleName() {
        return rulerUsesTitleName;
    }

    public void setRulerUsesTitleName(boolean rulerUsesTitleName) {
        this.rulerUsesTitleName = rulerUsesTitleName;
    }

    public boolean isLandless() {
        return landless;
    }

    public void setLandless(boolean landless) {
        this.landless = landless;
    }

    public boolean isNoAutomaticClaims() {
        return noAutomaticClaims;
    }

    public void setNoAutomaticClaims(boolean noAutomaticClaims) {
        this.noAutomaticClaims = noAutomaticClaims;
    }

    public boolean isAlwaysFollowsPrimaryHeir() {
        return alwaysFollowsPrimaryHeir;
    }

    public void setAlwaysFollowsPrimaryHeir(boolean alwaysFollowsPrimaryHeir) {
        this.alwaysFollowsPrimaryHeir = alwaysFollowsPrimaryHeir;
    }

    public boolean isDestroyIfInvalidHeir() {
        return destroyIfInvalidHeir;
    }

    public void setDestroyIfInvalidHeir(boolean destroyIfInvalidHeir) {
        this.destroyIfInvalidHeir = destroyIfInvalidHeir;
    }

    public AIPrimaryPriority getAiPrimaryPriority() {
        return aiPrimaryPriority;
    }

    public void setAiPrimaryPriority(AIPrimaryPriority aiPrimaryPriority) {
        this.aiPrimaryPriority = aiPrimaryPriority;
    }

    public void addCulturalNames(String culture, String name) {
        culturalNames.put(culture, name);
    }

    public void addMaleName(String name) {
        maleNames.add(name);
    }

    public void setCulturalNames(HashMap<String, String> names) {
        this.culturalNames = names;
    }

    public void setMaleNames(List<String> names) {
        this.maleNames = names;
    }

    public void setDejureDriftDisabled(boolean dejure) {
        this.dejureDriftDisabled = dejure;
    }

    public void setCanBeNamedAfterDynasty(boolean value) {
        canBeNamedAfterDynasty = value;
    }

    public boolean getCanBeNamedAfterDynasty() {
        return canBeNamedAfterDynasty;
    }

    // --- printing methods ---

    // used to get yes or no from booleans
    private String printBoolean(boolean value) {
        return value ? "yes" : "no";
    }

    public abstract String print(String offset);

    public String printAttributes(String offset) {
        StringBuilder builder = new StringBuilder();

        if (province != 0) {
            builder.append(offset + printProvince());
        }
        if (color != null) {
            builder.append(offset + printColor());
        }
        if (color2 != null) {
            builder.append(offset + printColor2());
        }
        if (definiteForm) {
            builder.append(offset + printDefiniteForm());
        }
        if (capital != null) {
            builder.append(offset + printCapital());
        }
        if (canCreate != null) {
            builder.append(canCreate.print(offset));
        }
        if (canCreateOnPartition != null) {
            builder.append(canCreateOnPartition.print(offset));
        }
        if (!rulerUsesTitleName) {
            builder.append(offset + printRulerUsesTitleName());
        }
        if (landless) {
            builder.append(offset + printLandless());
        }
        if (noAutomaticClaims) {
            builder.append(offset + printNoAutomaticClaims());
        }
        if (alwaysFollowsPrimaryHeir) {
            builder.append(offset).append(printAlwaysFollowsPrimaryHeir());
        }
        if (destroyIfInvalidHeir) {
            builder.append(offset + printDestroyIfInvalidHeir());
        }
        if (dejureDriftDisabled) {
            builder.append(offset + printDejureDriftDisabled());
        }
        if (!canBeNamedAfterDynasty) {
            builder.append(offset + printCanBeNamedAfterDynasty());
        }
        if (aiPrimaryPriority != null) {
            builder.append(aiPrimaryPriority.print(offset));
        }
        if (culturalNames != null && !culturalNames.isEmpty()) {
            builder.append(printCulturalNames(offset));
        }
        if (maleNames != null && !maleNames.isEmpty()) {
            builder.append(offset + printMaleNames());
        }

        return builder.toString();
    }

    public String printColor() {
        return "color = { " + color.getRed() + " " + color.getGreen() + " " + color.getBlue() + " }\n";
    }

    public String printColor2() {
        return "color2 = { " + color2.getRed() + " " + color2.getGreen() + " " + color2.getBlue() + " }\n";
    }

    public String printCapital() {
        return "capital = " + capital + "\n";
    }

    public String printProvince() {
        return "province = " + province + "\n";
    }

    public String printDefiniteForm() {
        return "definite_form = " + printBoolean(definiteForm) + "\n";
    }

    public String printRulerUsesTitleName() {
        return "ruler_uses_title_name = " + printBoolean(rulerUsesTitleName) + "\n";
    }

    public String printLandless() {
        return "landless = " + printBoolean(landless) + "\n";
    }

    public String printNoAutomaticClaims() {
        return "no_automatic_claims = " + printBoolean(noAutomaticClaims) + "\n";
    }

    public String printAlwaysFollowsPrimaryHeir() {
        return "always_follows_primary_heir = " + printBoolean(alwaysFollowsPrimaryHeir) + "\n";
    }

    public String printDestroyIfInvalidHeir() {
        return "destroy_if_invalid_heir = " + printBoolean(destroyIfInvalidHeir) + "\n";
    }

    public String printDejureDriftDisabled() {
        return "de_jure_drift_disabled = " + printBoolean(dejureDriftDisabled) + "\n";
    }

    public String printCanBeNamedAfterDynasty() {
        return "can_be_named_after_dynasty = " + printBoolean(canBeNamedAfterDynasty) + "\n";
    }

    public String printAIPrimaryPriority(String offset) {
        return aiPrimaryPriority.print(offset + "\t");
    }

    public String printCulturalNames(String offset) {
        StringBuilder string = new StringBuilder();

        string.append(offset + "cultural_names = {\n");
        for (var set : culturalNames.entrySet()) {
            string.append(offset + "\t" + set.getKey() + " = " + set.getValue() + "\n");
        }
        string.append(offset + "}\n");

        return string.toString();
    }

    public String printMaleNames() {
        StringBuilder builder = new StringBuilder();

        builder.append("male_names = {");
        for (var name : maleNames) {
            builder.append(" " + name + " ");
        }
        builder.append("}\n");

        return builder.toString();
    }

}
