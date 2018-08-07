package ru.javabegin.training.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.javabegin.training.interfaces.UserDao;

import ru.javabegin.training.objects.User;


import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

@Component("sqliteDAO")
public class UserDaoSqlite extends DaoAbstract implements UserDao{

    /*
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    */


    //@Override
    public void insert(User user) {
        String sql="insert into users (username, password) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[] {user.getUserName(),user.getPassword()});

    }

    //@Override
    public void delete(User user) {

    }

    @Override
    public boolean checkUserNameExist(User user) {

        String sql = "select * from users where userName=?";
        try
        {
            User dbUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName()}, new UserRowMapper());
            if (user.getUserName().equals(dbUser.getUserName())) return true;
            return false;
        } catch (EmptyResultDataAccessException e){
            return false;
        }




       // jdbcTemplate.query(sql, new Object[] {user.getUserName()},new UserRowMapper())

        //jdbcTemplate.query(sql, params, new MP3RowMapper())

    }


    @Override
    public User checkUserPassword(User user) {

        String sql = "select * from users where userName=? and password=?";
        try{
            User dbUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName(),user.getPassword()}, new UserRowMapper());
            if (user.getUserName().equals(dbUser.getUserName()) &&
                 user.getPassword().equals(dbUser.getPassword())   ) return dbUser;

        } catch (EmptyResultDataAccessException e){
            return null;
        }
        return new User();



    }

    private static final class UserRowMapper implements RowMapper<User> {

        //@Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setIduser(rs.getInt("iduser"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));

            return user;
        }

    }



}
