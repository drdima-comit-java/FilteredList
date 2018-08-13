package ru.javabegin.training.objects.softList;

import ru.javabegin.training.objects.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilteredList {




    private BaseList baseList;
    private NewList newList;
    private int flId;
    private List<FilteredListDetails> fldList;

    public FilteredList() {

    }

    public FilteredList(BaseList baseList, NewList newList) {
        this.baseList = baseList;
        this.newList = newList;
        this.fldList = new ArrayList<FilteredListDetails>();
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





    public void removeBaseListItems()
    {
        String[] arBaseList = this.textToArray(this.baseList.getListContent());
        String[] arNewList = this.textToArray(this.newList.getListContent());
        String[] arFiltredList = arNewList.clone();

        Collection collBaseList = new ArrayList(Arrays.asList(arBaseList));
        Collection collNewList = new ArrayList(Arrays.asList(arNewList));
        Collection<String> collFilteredList = new ArrayList(Arrays.asList(arFiltredList));

        collFilteredList.removeAll( collBaseList );
        //System.out.println( collFilteredList );
        this.filtredListToFilteredListDetails(collFilteredList);



    }

    private void filtredListToFilteredListDetails(Collection<String> collFilteredList)
    {


        for (String s : collFilteredList) {
            //System.out.println("value= " + s);
            this.fldList.add(new FilteredListDetails(s,0));
        }
    }




    private String[] textToArray(String textStr)
    {
        String lines[] = textStr.split("\\r?\\n");
        return lines;
    }


}
