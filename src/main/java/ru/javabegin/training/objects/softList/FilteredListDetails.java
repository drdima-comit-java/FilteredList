package ru.javabegin.training.objects.softList;

public class FilteredListDetails {

    private int flId;
    private int fldId;
    private String fldName;
    private String appsPath;
    private int fldsId;
    private int fldsSort;
    private String fldsName;
    private String fldsCss;



    public FilteredListDetails() {
    }

    public FilteredListDetails(String fldName, int fldsId) {
        this.fldName = fldName;
        this.fldsId = fldsId;

    }

    public int getFldsSort() {
        return fldsSort;
    }

    public void setFldsSort(int fldsSort) {
        this.fldsSort = fldsSort;
    }

    public String getAppsPath() {
        return appsPath;
    }

    public void setAppsPath(String appsPath) {
        this.appsPath = appsPath;
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
