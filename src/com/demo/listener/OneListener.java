package com.demo.listener;

import com.demo.ontity.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    //  在tomcat启动时，预先创建20个Connection，在userDao。add执行时将实现创建好的connection交给add方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
         JdbcUtil util = new JdbcUtil();
        Map map = new HashMap();
        for (int i = 1; i <= 20; i++) {
            Connection con = util.getCon();
            System.out.println("在Http服务器启动时，创建Connection " + con);
//            true表示这个通道处于空闲状态，false通道正在被使用
            map.put(con, true);
        }
//  为了在http服务器运行期间，一直都可以使用20个Connection，将connection保存到全局作用与对象
        ServletContext applation = servletContextEvent.getServletContext();
        applation.setAttribute("key1", map);
    }

    //    map被销毁了
//在Http服务器关闭时刻，将全局作用域对象20个connection销毁
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        Map map = (Map) application.getAttribute("key1");

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Connection con = (Connection) it.next();
            if (con != null) {
                System.out.println("兄弟们，我" + con + "先行一步，20年后还是一条好汉");
            }
        }
    }
}
