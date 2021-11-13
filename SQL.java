package javaapplication1;
import java.sql.*;

import javax.swing.JLabel;
public class SQL {
 Connection conn;
 public Connection getConn() {
   try {
    Class.forName("com.mysql.jdbc.Driver");
                 
             String url="jdbc:mysql://localhost:3306/score_management"
            + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false"; //JDBC的URL    

             conn = DriverManager.getConnection(url, "root","123456"); //建立数据库连接，获得连接对象conn
   }catch(ClassNotFoundException e){
    e.printStackTrace();
   }catch (SQLException e) {
   e.printStackTrace();
  }
  return conn;
 }  
  
 public static void main(String[] args) {
  
  SQL bd=new SQL();
  Connection conn=bd.getConn();
      try {
      Statement stmt = conn.createStatement(); //创建Statement对象
      try {
//         String sql = "INSERT INTO `score_management`.`student` (`id`, `name`, `math`, `program`, `software`, `math2`, `aver`, `sum`) VALUES ('100003', '李四', '99', '99', '99', '99', '99', '396');"; //要执行的SQL
//          PreparedStatement pst = conn.prepareStatement(sql);
//          String sql = "INSERT INTO `score_management`.`student`(`id`) VALUES (?)"; //要执行的SQL
//          PreparedStatement pst = conn.prepareStatement(sql);
//          int a=100009,b=100;
//          pst.setInt(1,100006);                             //传入带占位符的SQL语句
//  pst.setString(2,"ayi");
//  pst.setInt(3,b);
//  pst.setInt(4,b);
//  pst.setInt(5,b);
//  pst.setInt(6,b);
//  pst.setInt(7,b);
//  pst.setInt(8,b);
//   
//          ResultSet rs = pst.executeQuery();
// pst.executeUpdate(); //执行 update和insert、delete等sql语句

    	  String sql = "select * from student where id=?;";    //要执行的SQL
          PreparedStatement pst = conn.prepareStatement(sql);
          pst.setInt(1,100001);  
          ResultSet rs = pst.executeQuery();//创建数据对象，产生单个结果集的语句
            System.out.println(rs.getInt("id"));
//          while(rs.next()) {
//          if(rs.getInt("id")==n) {
//          a=1;//有成绩
//            //从数据库查找成绩
//        a1=new JLabel("学号："+rs.getInt(1));
  pst.close();
      }catch(SQLIntegrityConstraintViolationException e1) {
      
      }
          stmt.close();
          conn.close();
      }catch(SQLException e2){
      e2.printStackTrace();
      }
      }
 
}
