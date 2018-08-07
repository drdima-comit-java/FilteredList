package ru.javabegin.training.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.javabegin.training.interfaces.BaseListDao;
import ru.javabegin.training.objects.softList.BaseList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("sqliteDAO2")
public class BaseListDaoSqlite extends  DaoAbstract implements BaseListDao {

    private static final Logger logger = LoggerFactory.getLogger(BaseListDao.class);

    @Override
    public List<BaseList> getBaseLists(int iduser) {

        String sql="select * from base_list where iduser=?";
        return jdbcTemplate.query(sql, new Object[] {iduser},new BaseListRowMapper());
    }


    public Map<String,String> getBaseListsMap(int iduser) {

        List<BaseList> results=this.getBaseLists(iduser);

        Map<String,String> myLists = new LinkedHashMap<String,String>();
        for (BaseList v : results){
            myLists.put(  Integer.toString(v.getIdbl()),v.getListName() );

        }
        return myLists;

    }





    @Override
    public BaseList getBaseList(int idbl) {
        String sql="select * from base_list where idbl=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {idbl},new BaseListRowMapper());
    }


    @Override
    public void insert(BaseList bl) {
        String sql="insert into base_list (iduser, blName, blContent, blDateCreation) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,new Object[] {
                bl.getUser().getIduser(),
                bl.getListName(),
                bl.getListContent(),
                new java.util.Date()
        });
    }

    @Override
    public void delete(int idbl) {
        String sql="delete from base_list where idbl=?";
        jdbcTemplate.update(sql,idbl);
    }


    @Override
    public void update(BaseList bl) {
        String updateQuery = "update base_list set blName = ? , blContent= ? where idbl = ?";
        jdbcTemplate.update(updateQuery,
                new Object[] {bl.getListName(),bl.getListContent(),bl.getIdbl()});
    }

    private static final class BaseListRowMapper implements RowMapper<BaseList> {
        //@Override
        public BaseList mapRow(ResultSet rs, int rowNum) throws SQLException {
            BaseList bl = new BaseList();

            bl.setIdbl(rs.getInt("idbl"));
            bl.setUserId(rs.getInt("iduser"));
            bl.setListName(rs.getString("blName"));
            bl.setListContent(rs.getString("blContent"));

            java.util.Date date=null;
            Timestamp timestamp = rs.getTimestamp("blDateCreation");
            if (timestamp != null)
                date = new java.util.Date(timestamp.getTime());
            bl.setListDate(date);
            return bl;
        }

    }






}
