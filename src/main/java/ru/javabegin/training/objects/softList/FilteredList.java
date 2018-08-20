package ru.javabegin.training.objects.softList;

import ru.javabegin.training.objects.User;

import java.lang.reflect.Array;
import java.util.*;

public class FilteredList {




    private BaseList baseList;
    private NewList newList;
    private int flId;
    private List<FilteredListDetails> fldList;
    private int userId;
    private String flName;
    private Date flDateCreation;

    public FilteredList() {

    }

    public FilteredList(BaseList baseList, NewList newList) {
        this.baseList = baseList;
        this.newList = newList;
        //this.userId = userId;
        this.fldList = new ArrayList<FilteredListDetails>();
    }

    public Date getFlDateCreation() {
        return flDateCreation;
    }

    public void setFlDateCreation(Date flDateCreation) {
        this.flDateCreation = flDateCreation;
    }

    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlId() {
        return flId;
    }

    public void setFlId(int flId) {
        if (this.flId==0)
        this.flId = flId;
    }

    public List<FilteredListDetails> getFldList() {
        return fldList;
    }


    public List<FilteredListDetails> getFldList(int flId) {

        for (FilteredListDetails fld: this.fldList)
        {
            if (fld.getFlId()==0) {
                fld.setFlId(flId);
            }
        }

        setFlId(flId);

        return fldList;
    }

    public BaseList getBaseList() {
        return baseList;
    }

    public NewList getNewList() {
        return newList;
    }





    public void removeBaseListItems(int fldsIdInitial)
    {
        String[] arBaseList = this.textToArray(this.baseList.getListContent());
        String[] arNewList = this.textToArray(this.newList.getListContent());
        String[] arFiltredList = arNewList.clone();

        Collection collBaseList = new ArrayList(Arrays.asList(arBaseList));
        Collection collNewList = new ArrayList(Arrays.asList(arNewList));
        Collection<String> collFilteredList = new ArrayList(Arrays.asList(arFiltredList));

        collFilteredList.removeAll( collBaseList );
        //System.out.println( collFilteredList );
        this.filtredListToFilteredListDetails(collFilteredList, fldsIdInitial);



    }

    private void filtredListToFilteredListDetails(Collection<String> collFilteredList,int fldsId)
    {


        for (String s : collFilteredList) {
            //System.out.println("value= " + s);
            this.fldList.add(new FilteredListDetails(s,fldsId));
        }
    }




    private String[] textToArray(String textStr)
    {
        String lines[] = textStr.split("\\r?\\n");
        return lines;
    }


}
