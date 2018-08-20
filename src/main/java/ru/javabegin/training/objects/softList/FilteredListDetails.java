package ru.javabegin.training.objects.softList;

public class FilteredListDetails {

    private int flId;
    private int fldId;
    private String fldName;
    private int fldsId;
    private String fldsName;
    private String fldsCss;



    public FilteredListDetails() {
    }

    public FilteredListDetails(String fldName, int fldsId) {
        this.fldName = fldName;
        this.fldsId = fldsId;

    }

    public String getFldsCss() {
        return fldsCss;
    }

    public void setFldsCss(String fldsCss) {
        this.fldsCss = fldsCss;
    }

    public String getFldsName() {
        return fldsName;
    }

    public void setFldsName(String fldsName) {
        this.fldsName = fldsName;
    }

    public int getFldsId() {
        return fldsId;
    }

    public void setFldsId(int fldsId) {
        this.fldsId = fldsId;
    }

    public int getFldId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
    }

    public String getFldName() {
        return fldName;
    }

    public void setFldName(String fldName) {
        this.fldName = fldName;
    }



    public int getFlId() {
        return flId;
    }

    public void setFlId(int flId) {
        this.flId = flId;
    }
}
