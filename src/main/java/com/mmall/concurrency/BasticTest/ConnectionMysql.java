package com.mmall.concurrency.BasticTest;

import java.sql.*;

public class ConnectionMysql {

    //原生jdbc操作；
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://127.0.0.1:3306/informationtest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String USER="root";
        String PASSWORD="0225";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from emp");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){

            System.out.println(rs.getString("ename")+" "
                    +rs.getString("job"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
