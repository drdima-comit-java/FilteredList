package ru.javabegin.training.interfaces;

import ru.javabegin.training.objects.softList.BaseList;

import java.util.List;

public interface NewListDao {





    List<BaseList> getBaseLists(int iduser);
    BaseList getBaseList(int idbl);

    void delete(int idbl);
    void update(BaseList bl);
}
