package guru.qa.model;

import com.google.gson.annotations.SerializedName;

public class Glossary {

    private String title;
    @SerializedName("ID")
    private Integer ID;

    private GlossaryInner glossary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public GlossaryInner getGlossary() {
        return glossary;
    }

    public void setGlossary(GlossaryInner glossary) {
        this.glossary = glossary;
    }
}


