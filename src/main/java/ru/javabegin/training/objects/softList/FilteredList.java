package ru.javabegin.training.objects.softList;

import ru.javabegin.training.objects.User;

public class FilteredList  extends  SoftListAbstract{


    private BaseList baseList;
    private NewList newList;

    public FilteredList(BaseList baseList, NewList newList) {
        this.baseList = baseList;
        this.newList = newList;
    }

    public void removeBaseListItems()
    {
        this.textToArray(this.baseList.getListContent());
    }


    private String[] textToArray(String textStr)
    {
        String lines[] = textStr.split("\\r?\\n");
        return lines;
    }


}
