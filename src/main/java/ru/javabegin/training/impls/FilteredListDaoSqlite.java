package ru.javabegin.training.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javabegin.training.interfaces.BaseListDao;
import ru.javabegin.training.interfaces.FilteredListDao;
import ru.javabegin.training.objects.softList.BaseList;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.NewList;

import java.util.Collection;
import java.util.List;


@Component("sqliteDAO3")
public class FilteredListDaoSqlite extends DaoAbstract implements FilteredListDao{


    private static final Logger logger = LoggerFactory.getLogger(FilteredListDaoSqlite.class);




    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertFilteredList(FilteredList fl) {

        BaseList bl = fl.getBaseList();
        NewList nl = fl.getNewList();
        List<FilteredListDetails> fld=fl.getFldList();


        String sql="INSERT INTO filtered_list (baseListContent, newListContent, flName, flDateCreation) " +
                "                      VALUES (:baseListContent, :newListContent, :flName, :flDateCreation)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("baseListContent", bl.getListContent());
        params.addValue("newListContent", nl.getListContent());
        params.addValue("flName", nl.getListName());
        params.addValue("flDateCreation", new java.util.Date());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        //jdbcTemplate.update(sql,params);
        namedParameterJdbcTemplate.update(sql,params,keyHolder);

        Number key = keyHolder.getKey();
        System.out.println("Newly persisted customer generated id: " + key.longValue());

        this.insertFilteredListDetails(fl.getFldList(key.longValue()));


    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void insertFilteredListDetails(List<FilteredListDetails> fld)
    {



        String sql="INSERT INTO filtered_list_details (fldName, fldStatus, flId) " +
                "VALUES (:fldName, :fldStatus, :flId)";


        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(fld.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(sql, batch);


        //return updateCounts.length;
    }


}
