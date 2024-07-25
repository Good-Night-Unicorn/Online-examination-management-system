package com.demo.ontity;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
    final String url = "jdbc:mysql://localhost:3306/exam";
    final String username = "root";
    final String password = "root";
    PreparedStatement ps = null;
    Connection con = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //通过全局作用域对象得到connection---------start
    public Connection getCon(HttpServletRequest request) {
// 通过请求对象，调用全局作用域对象
        ServletContext application = request.getServletContext();
//        从全局作用域得到map
        Map map = (Map) application.getAttribute("key1");
//        从map得到一个处于空闲状态connection
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            con = (Connection) it.next();
            boolean flag = (boolean) map.get(con);
            if (flag == true) {
                map.put(con, false);
                break;
            }
        }
        return con;
    }

    public PreparedStatement createStatement(String sql, HttpServletRequest request) {
        try {
            ps = getCon(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("key1");
        map.put("key1", true);
    }
    //通过全局作用域对象得到connection---------start
//    将jar包中driver实现类加载到jvm中


    public Connection getCon() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public PreparedStatement createStatement(String sql) {
        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {

            }
        }
    }
}
