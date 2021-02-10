package com.spring3;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserDao extends JdbcDaoSupport {
    public void selectUser(){
        List<Map<String, Object>> list = getJdbcTemplate().queryForList("select * from users");
        for(Map<String,Object> map : list){
            System.out.println(map);
        }
    }

    public List<UserBean> query1(){
        return getJdbcTemplate().query("select * from users where id=? or pwd=?"
            , new ResultSetExtractor<List<UserBean>>() {
                @Override
                public List<UserBean> extractData(ResultSet resultSet)
                        throws SQLException, DataAccessException {
                    List<UserBean> list = new ArrayList<>();
                    while(resultSet.next()){
                        UserBean userBean = new UserBean();
                        userBean.setId(resultSet.getInt(1));
                        userBean.setUsername(resultSet.getString(2));
                        userBean.setPwd(resultSet.getString(3));
                        userBean.setBirt(resultSet.getString(4));
                        userBean.setTel(resultSet.getString(5));
                        userBean.setAddr(resultSet.getString(6));
                        list.add(userBean);
                    }
                    return list;
                }
            }
            ,1,"123");
    }

    public List<UserBean> query2(){
        List<UserBean> list = new ArrayList<>();
        getJdbcTemplate().query("select * from users where id=? or pwd=?"
                , new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        UserBean userBean = new UserBean();
                        userBean.setId(resultSet.getInt(1));
                        userBean.setUsername(resultSet.getString(2));
                        userBean.setPwd(resultSet.getString(3));
                        userBean.setBirt(resultSet.getString(4));
                        userBean.setTel(resultSet.getString(5));
                        userBean.setAddr(resultSet.getString(6));
                        list.add(userBean);
                    }
                }
                , 1, "123");
        return list;
    }

    public List<UserBean> query3(){
        return getJdbcTemplate().query("select * from users where id=? or pwd=?"
                , new RowMapper<UserBean>() {
                    @Override
                    public UserBean mapRow(ResultSet resultSet, int i) throws SQLException {
                        UserBean userBean = new UserBean();
                        userBean.setId(resultSet.getInt(1));
                        userBean.setUsername(resultSet.getString(2));
                        userBean.setPwd(resultSet.getString(3));
                        userBean.setBirt(resultSet.getString(4));
                        userBean.setTel(resultSet.getString(5));
                        userBean.setAddr(resultSet.getString(6));
                        return userBean;
                    }
                }
                , 1, "123");
    }

    public List<UserBean> query4(){
        return getJdbcTemplate().query("select * from users where id=? or pwd=?"
                , new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1,1);
                        preparedStatement.setString(2,"123");
                    }
                }
                , new RowMapper<UserBean>() {
                    @Override
                    public UserBean mapRow(ResultSet resultSet, int i) throws SQLException {
                        UserBean userBean = new UserBean();
                        userBean.setId(resultSet.getInt(1));
                        userBean.setUsername(resultSet.getString(2));
                        userBean.setPwd(resultSet.getString(3));
                        userBean.setBirt(resultSet.getString(4));
                        userBean.setTel(resultSet.getString(5));
                        userBean.setAddr(resultSet.getString(6));
                        return userBean;
                    }
                });
    }

    public List<String> query51(){
        return getJdbcTemplate()
                .queryForList("select username from users",String.class);
    }

    public Map<String,Object> query52(){
        return getJdbcTemplate()
                .queryForMap("select * from users where id=?",2);
    }

    public UserBean query53(){
        return getJdbcTemplate()
                .queryForObject("select * from users where id=?"
                        , new BeanPropertyRowMapper<UserBean>(UserBean.class)
                        ,2);
    }

    public void query54(){
        SqlRowSet srs =  getJdbcTemplate()
                .queryForRowSet("select * from users where id=?"
                        ,2);
        while(srs.next()){
            System.out.print(srs.getInt(1)+"\t");
            System.out.print(srs.getString(2)+"\t");
            System.out.print(srs.getString(3)+"\t");
            System.out.print(srs.getString(4)+"\t");
            System.out.print(srs.getString(5)+"\t");
            System.out.println(srs.getString(6));
        }
    }

    public List<UserBean> query55(){
        return getJdbcTemplate()
                .query(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        return connection.prepareStatement("select * from users where id=1");
                    }
                },new BeanPropertyRowMapper<UserBean>(UserBean.class));
    }

    public void update1(){
        int a= getJdbcTemplate().update("INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)"
                ,"李四","123","1998-02-11","12030241",null);
        System.out.println(a);
    }

    public void update2(){
        int a= getJdbcTemplate().update("INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)"
                , new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1,"李思思");
                        ps.setString(2,"123");
                        ps.setString(3,null);
                        ps.setString(4,null);
                        ps.setString(5,null);
                    }
                });
        System.out.println(a);
    }

    public UserBean update3(UserBean user){
        int a= getJdbcTemplate().update("INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)"
                , new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, user.getUsername());
                        ps.setString(2, user.getPwd());
                        ps.setString(3, user.getBirt());
                        ps.setString(4, user.getTel());
                        ps.setString(5, user.getAddr());
                    }
                });
        System.out.println(a);
        return user;
    }

    public UserBean update4(UserBean user){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        int a= getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)"
                        ,new String[]{"id"});
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPwd());
                ps.setString(3, user.getBirt());
                ps.setString(4, user.getTel());
                ps.setString(5, user.getAddr());
                return ps;
            }
        },keyHolder);
        System.out.println(a);
        user.setId(keyHolder.getKey().intValue());
        return user;
    }

    public void update51(List<UserBean> users){
        List<Object[]> args = new ArrayList<>();
        for(UserBean user : users){
            Object[] arg = new Object[]{user.getUsername(),user.getPwd(),user.getBirt()
                            ,user.getTel(),user.getAddr()};
            args.add(arg);
        }
        int[] i = getJdbcTemplate().batchUpdate("INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)",
                args);
        System.out.println(Arrays.toString(i));
    }

    public void update52(List<UserBean> users){
        int[] i = getJdbcTemplate().batchUpdate(
                "INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)" // 批量操作的sql语句
                , new BatchPreparedStatementSetter() {// 批量设置值
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1,users.get(i).getUsername());
                        ps.setString(2,users.get(i).getPwd());
                        ps.setString(3,users.get(i).getBirt());
                        ps.setString(4,users.get(i).getTel());
                        ps.setString(5,users.get(i).getAddr());
                    }
                    @Override
                    public int getBatchSize() {
                        return users.size();
                    }
                });
        System.out.println(Arrays.toString(i));
    }

    public void update53(List<UserBean> users){
        // 返回int[][]型二维数组,第一维批量处理的批次，第二维是每批次的执行结果行数
        /* 例： 23条记录 ， batchSize是10 ， 结果
            1	1	1	1	1	1	1	1	1	1
            1	1	1	1	1	1	1	1	1	1
            1	1	1
         */
        int[][] i = getJdbcTemplate().batchUpdate(
                "INSERT INTO users (username, pwd, birt, tel, addr) VALUES (?,?,?,?,?)" // 批量操作的sql语句
                , users //要处理的数据 ，通常是集合
                , 10 // 一次性处理的记录数
                , new ParameterizedPreparedStatementSetter<UserBean>() { // 设置值
                    @Override
                    public void setValues(PreparedStatement ps, UserBean user) throws SQLException {
                        ps.setString(1,user.getUsername());
                        ps.setString(2,user.getPwd());
                        ps.setString(3,user.getBirt());
                        ps.setString(4,user.getTel());
                        ps.setString(5,user.getAddr());
                    }
                });
        for(int j=0;j<i.length;j++){
            for(int k=0;k<i[j].length;k++){
                System.out.print(i[j][k]+"\t");
            }
            System.out.println();
        }
    }
}
