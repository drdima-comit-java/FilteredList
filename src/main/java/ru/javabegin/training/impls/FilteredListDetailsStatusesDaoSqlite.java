package ru.javabegin.training.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.javabegin.training.interfaces.FilteredListDetailsStatusesDao;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("sqliteDAO5")
public class FilteredListDetailsStatusesDaoSqlite extends DaoAbstract  implements FilteredListDetailsStatusesDao {

    private static final Logger logger = LoggerFactory.getLogger(FilteredListDetailsStatusesDaoSqlite.class);


    public int getInitialFldsId()
    {
        String sql="select fldsId from filtered_list_details_statuses \n" +
                "order by fldsSort\n" +
                "Limit 0,1";
        int fldsId = jdbcTemplate.queryForObject(sql, Integer.class );
        return fldsId;
    }

    public List<FilteredListDetailsStatus> getStatusesList()
    {
        String sql="select * from filtered_list_details_statuses ORDER by fldsSort " ;

        List<FilteredListDetailsStatus> flds = jdbcTemplate.query(sql, new fldsRowMapper() );
        return flds;

    }


    private static final class fldsRowMapper implements RowMapper<FilteredListDetailsStatus> {
        //@Override
        public FilteredListDetailsStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilteredListDetailsStatus flds= new FilteredListDetailsStatus();

            flds.setFldsId(rs.getInt("fldsId"));
            flds.setFldsName(rs.getString("fldsName"));
            flds.setFldsCss(rs.getString("fldsCss"));
            flds.setFldsSort(rs.getInt("fldsSort"));

            return flds;
        }

    }


}
