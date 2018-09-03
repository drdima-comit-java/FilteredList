package ru.javabegin.training.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.javabegin.training.interfaces.AppsListDao;
import ru.javabegin.training.objects.softList.Apps;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.FilteredListDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component("sqliteDAO6")
public class AppsListDaoSqlite extends DaoAbstract implements AppsListDao {
    private static final Logger logger = LoggerFactory.getLogger(FilteredListDaoSqlite.class);

    public List<Apps> getAppsList()
    {
        String sql="select * \n" +
                "from apps\n" ;

        return jdbcTemplate.query(sql, new Object[]{}, new appsRowMapper() );
    }


    public String getPathbyName(String appsName)
    {
        String sql="select * \n" +
                "from apps\n" +
                "WHERE appsName=?" ;
        try
        {
            return jdbcTemplate.queryForObject(sql, new Object[]{appsName}, new appsRowMapper() ).getAppsPath();
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    public void addApp(String appsName, String appsPath)
    {
        String sql="insert into apps (appsName, appsPath) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[] {appsName,appsPath});
    }

    public void deleteApp(int appsId)
    {
        String sql="DELETE FROM apps WHERE appsId=?";
        jdbcTemplate.update(sql,new Object[] {appsId});
    }


    private static final class appsRowMapper implements RowMapper<Apps> {
        //@Override
        public Apps mapRow(ResultSet rs, int rowNum) throws SQLException {
            Apps apps= new Apps();

            apps.setAppsId(rs.getInt("appsId"));
            apps.setAppsName(rs.getString("appsName"));
            apps.setAppsPath(rs.getString("appsPath"));



            return apps;
        }

    }


}
