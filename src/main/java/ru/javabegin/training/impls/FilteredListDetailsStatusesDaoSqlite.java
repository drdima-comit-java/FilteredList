package ru.javabegin.training.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.javabegin.training.interfaces.FilteredListDetailsStatusesDao;
import ru.javabegin.training.objects.softList.FilteredListDetails;

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
}
