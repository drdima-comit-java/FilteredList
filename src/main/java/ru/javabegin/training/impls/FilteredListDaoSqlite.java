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


        String sql="INSERT INTO filtered_list (baseListContent, newListContent, flName, flDateCreation,userId) " +
                "                      VALUES (:baseListContent, :newListContent, :flName, :flDateCreation, :userId)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("baseListContent", bl.getListContent());
        params.addValue("newListContent", nl.getListContent());
        params.addValue("flName", nl.getListName());
        params.addValue("flDateCreation", new java.util.Date());
        params.addValue("userId", nl.getUserId());


        KeyHolder keyHolder = new GeneratedKeyHolder();

        //jdbcTemplate.update(sql,params);
        namedParameterJdbcTemplate.update(sql,params,keyHolder);
        fl.setFlId(keyHolder.getKey().intValue());

        this.insertFilteredListDetails(fl.getFldList(keyHolder.getKey().intValue()));


    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void insertFilteredListDetails(List<FilteredListDetails> fld)
    {



        String sql="INSERT INTO filtered_list_details (fldName, fldsId, flId) " +
                "VALUES (:fldName, :fldsId, :flId)";


        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(fld.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(sql, batch);

        //System.out.println(updateCounts);


        //return updateCounts.length;
    }


    public List<FilteredListDetails> getFilteredListsDetails(int flId)
    {
        String sql="select * \n" +
                "from filtered_list_details fld\n" +
                "inner join filtered_list_details_statuses flds \n" +
                "on \n" +
                "fld.fldsId = flds.fldsId\n" +
                "where flId=?\n" +
                "ORDER BY fld.fldId";
        return jdbcTemplate.query(sql, new Object[]{flId}, new fldRowMapper() );
    }

    public FilteredListDetails getFilteredListDetails(int fldId)
    {
        String sql="select * \n" +
                "from filtered_list_details fld\n" +
                "inner join filtered_list_details_statuses flds \n" +
                "on \n" +
                "fld.fldsId = flds.fldsId\n" +
                "where fldId=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{fldId}, new fldRowMapper() );
    }




    public List<FilteredList> getFilteredLists(int userId)
    {
        String sql="select * from filtered_list where userId=?  order by flDateCreation desc";



        return jdbcTemplate.query(sql, new Object[]{userId}, new flRowMapper() );
    }

    public FilteredList getFilteredList(int flId)
    {
        String sql="select * from filtered_list where flId=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{flId}, new flRowMapper() );
    }


    public void flDelete(int flId)
    {

        String sql="DELETE from filtered_list_details where flId=?";
        jdbcTemplate.update(sql, new Object[]{flId} );


        sql="DELETE from filtered_list where flId=?";
        jdbcTemplate.update(sql, new Object[]{flId} );


    }



    public void deleteFldId(int fldId)
    {
        String sql="DELETE from filtered_list_details where fldId=?";
        jdbcTemplate.update(sql, new Object[]{fldId} );
    }


    public void updateFldStatus(int fldId, int fldsId)
    {
        String updateQuery = "update filtered_list_details set fldsId = ?  where fldId = ?";
        jdbcTemplate.update(updateQuery, new Object[] {fldsId,fldId});
    }








    private static final class fldRowMapper implements RowMapper<FilteredListDetails> {
        //@Override
        public FilteredListDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilteredListDetails fld= new FilteredListDetails();

            fld.setFldId(rs.getInt("fldId"));
            fld.setFldName(rs.getString("fldName"));
            fld.setFldsId(rs.getInt("fldsId"));
            fld.setFldsName(rs.getString("fldsName"));
            fld.setFldsCss(rs.getString("fldsCss"));
            fld.setFlId(rs.getInt("flId"));
            return fld;
        }

    }

    private static final class flRowMapper implements RowMapper<FilteredList> {
        //@Override
        public FilteredList mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilteredList fl= new FilteredList();

            fl.setFlId(rs.getInt("flId"));
            fl.setFlName(rs.getString("flName"));
            fl.setFlDateCreation(rs.getTimestamp("flDateCreation"));
            fl.setUserId(rs.getInt("userId"));
            //fl.setUserId(rs.getInt("userId"));


            return fl;
        }

    }


}
