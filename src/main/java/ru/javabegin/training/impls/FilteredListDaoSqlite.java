package ru.javabegin.training.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.javabegin.training.interfaces.FilteredListDao;
import ru.javabegin.training.objects.softList.BaseList;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.NewList;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


@Component("sqliteDAO4")
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
        fl.setFlId(keyHolder.getKey().intValue());

        this.insertFilteredListDetails(fl.getFldList(keyHolder.getKey().intValue()));


    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void insertFilteredListDetails(List<FilteredListDetails> fld)
    {



        String sql="INSERT INTO filtered_list_details (fldName, fldStatus, flId) " +
                "VALUES (:fldName, :fldStatus, :flId)";


        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(fld.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(sql, batch);

        System.out.println(updateCounts);


        //return updateCounts.length;
    }


    public List<FilteredListDetails> getFilteredListDetails(int flId)
    {
        String sql="select * from filtered_list_details where flId=?";
        return jdbcTemplate.query(sql, new Object[]{flId}, new fldRowMapper() );
    }


    private static final class fldRowMapper implements RowMapper<FilteredListDetails> {
        //@Override
        public FilteredListDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilteredListDetails fld= new FilteredListDetails();

            fld.setFldId(rs.getInt("fldId"));
            fld.setFldName(rs.getString("fldName"));
            fld.setFldStatus(rs.getInt("fldStatus"));
            fld.setFlId(rs.getInt("flId"));


            return fld;
        }

    }


}
