package ru.javabegin.training.objects.softList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javabegin.training.impls.BaseListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDetailsStatusesDaoSqlite;
import ru.javabegin.training.interfaces.FilteredListDetailsStatusesDao;

import java.util.Iterator;
import java.util.List;


public class FilteredListDetailsStatuses {





    //private int minSort;
    //private int maxSort;



    private List<FilteredListDetailsStatus> fldsList;

    public FilteredListDetailsStatuses(FilteredListDetailsStatusesDaoSqlite fldssSql) {

        this.fldsList=fldssSql.getStatusesList();

    }

    public int getMinStatusId()
    {
        int minStatusId=1;
        Iterator itr = fldsList.iterator();
        if (itr.hasNext())
        {
             FilteredListDetailsStatus flds= (FilteredListDetailsStatus) itr.next();
             minStatusId = flds.getFldsId();
        }
        return minStatusId;

    }





    public FilteredListDetailsStatus getNextStatus(int fldsId)
    {
        Iterator itr = fldsList.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            FilteredListDetailsStatus flds= (FilteredListDetailsStatus) itr.next();
            if (flds.getFldsId()==fldsId)
            {
                if (itr.hasNext()) return (  (FilteredListDetailsStatus) itr.next()  );
                else {
                    return fldsList.iterator().next(); //first one
                }
            }
        }
        return null;
    }



}
