package com.demo.dao;

import com.demo.ontity.JdbcUtil;
import com.demo.ontity.Users;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();

    //用户注册
//    JBDC规范中，Connection创建与销毁最浪费时间。
    public int add(Users user) {
        String sql = "insert into users(userName,password,sex,email)" + "values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }

    public int add(Users user, HttpServletRequest request) {
        String sql = "insert into users(userName,password,sex,email)" + "values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql, request);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;

    }

    //    查询所有用户信息
    public List findAll() {
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userlist = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userID = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String sex = rs.getString(4);
                String email = rs.getString(5);
                Users user = new Users(userID, userName, password, sex, email);
                userlist.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            {
                util.close();
            }
        }
        return userlist;
    }

    //    根据用户编号删除用户信息
    public int delete(String userID) {
        String sql = "delete from users where userID=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.parseInt(userID));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //    登陆验证
    public int login(String userName, String password) {
        String sql = "select count(*) from users where userName=? and password=? ";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count(*)");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;

    }

    public int update(Users user) {

        String sql = "update users set userName=?,password=?,sex=?,email=? where userID=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getUserID());

            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public Users findByID(String userID) {
        String sql = "select * from users where userID=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        Users users = null;
        try {
            ps.setInt(1, Integer.parseInt(userID));
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userId = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String sex = rs.getString(4);
                String email = rs.getString(5);

                users = new Users(userId, userName, password, sex, email);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }

        return users;
    }
}
