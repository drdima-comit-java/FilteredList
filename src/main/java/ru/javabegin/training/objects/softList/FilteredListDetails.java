package ru.javabegin.training.objects.softList;

public class FilteredListDetails {

    private int fldId;
    private String fldName;
    private int fldStatus;
    private int flId;

    public FilteredListDetails() {
    }

    public FilteredListDetails(String fldName, int fldStatus) {
        this.fldName = fldName;
        this.fldStatus = fldStatus;

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

    public int getFldStatus() {
        return fldStatus;
    }

    public void setFldStatus(int fldStatus) {
        this.fldStatus = fldStatus;
    }

    public int getFlId() {
        return flId;
    }

    public void setFlId(int flId) {
        this.flId = flId;
    }
}
