package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JLabel;
public class GUISeeknum extends Frame implements ActionListener{
Frame my;
String b;
private JLabel a1;
private JButton b1,b2,b3;
private TextField c1;
private GridBagLayout gb;
private GridBagConstraints gbc;
public GUISeeknum() {
a1=new JLabel("请输入学生姓名： ");
c1=new TextField(20);
gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
b1=new JButton("查询"); //初始化按钮 btn1 
b2=new JButton("退出"); 
b3=new JButton("总体成绩"); 
    b1.addActionListener(this);
    b3.addActionListener(this);
b2.addActionListener(this);
Panel p0 = new Panel(); //创建，并初始化面板 p1 
p0.add(a1); 
p0.add(c1);
Panel p1 = new Panel();
p1.add(b1);
p1.add(b3);
p1.add(b2);
 
addWindowListener(new WindowAdapter(){ 
public void windowClosing(WindowEvent e){
     setVisible(false);
     dispose();
System.exit(0); //程序退出
} 
}); 
   
gbc.fill=GridBagConstraints.HORIZONTAL; //设置 gbc 的 fill 域
addComponent(p0,0, 2, 1, 2);
addComponent(p1,4, 2, 1, 1);
}
public void actionPerformed(ActionEvent e) {
if(e.getActionCommand()=="查询") {
b=c1.getText();
gui1(b);
}else if(e.getActionCommand()=="退出") {
     setVisible(false);
     dispose();
} else if (e.getActionCommand() == "总体成绩") {
            GUIOutnum mygb = new GUIOutnum();
            mygb.setSize(700, 500);
            mygb.setVisible(true);
}else if(e.getActionCommand()=="返回") {
my.setVisible(false);
     my.dispose();
}
}
public void gui1(String n) {
JLabel a0;
JLabel a1,a2,a3,a4,a5,a6,a7,a8;
my=new Frame();
my.setBounds(300,300,450,450);
my.setLayout(null);
my.setVisible(true); 
JButton b1=new JButton("返回");
b1.addActionListener(this);
a0=new JLabel("该学生不存在！ ");
int a=0;
SQL bd=new SQL();
Connection conn=bd.getConn(); 
try {
            Statement stmt = conn.createStatement(); //创建Statement对象
            String sql = "select * from student;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象，产生单个结果集的语句
            while(rs.next()) {
            
            if(rs.getString("name").equals(n)) {
            a=1;//有成绩
              //从数据库查找成绩
          a1=new JLabel("学号："+rs.getInt(1));
          a2=new JLabel("姓名："+rs.getString(2));
          a3=new JLabel("高等数学：" +rs.getInt(3));
          a4=new JLabel("程序设计：" +rs.getInt(4));
          a5=new JLabel("软件工程：" +rs.getInt(5));
          a6=new JLabel("离散数学：" +rs.getInt(6));
          a7=new JLabel("平均分：" +rs.getInt(7));
          a8=new JLabel("总分：" +rs.getInt(8));
          my.add(a1);
          my.add(a2);
          my.add(a3);
          my.add(a4);
          my.add(a5);
          my.add(a6);
          my.add(a7);
          my.add(a8);
        a1.setBounds(70,20,300,60);// 距左边的距离   距顶部的距离   长度  高度
a2.setBounds(70, 70,300,50);
a3.setBounds(70, 110, 300,50);
a4.setBounds(70, 150, 300,50);
a5.setBounds(70, 190, 300,50);
a6.setBounds(70, 230, 300,50);
a7.setBounds(70, 270, 300,50);
a8.setBounds(70, 310, 300,50);
           
              //数据库
              break;
            }  
            }
          if(a==0) {
      my.add(a0);
      a0.setBounds(170,180,300,60);
          }
my.add(b1); 
b1.setBounds(300, 360, 100,40);
my.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent evt) {
my.setVisible(false);
my.dispose();
}
});
          rs.close();
            stmt.close();
            conn.close();
      }catch (SQLException e) {
      e.printStackTrace();
}
}
public void addComponent(Component c,int row,int col, int nrow,int ncol){ 
gbc.gridx=col; //设置组件显示区域的开始边单元格
gbc.gridy=row; //设置组件显示区域的顶端单元格
gbc.gridheight=ncol; //设置组件显示区域一列的单元格数
gbc.gridwidth=nrow; //设置组件显示区域一行的单元格数
gb.setConstraints(c,gbc); //设置布局的约束条件
add(c); //组件 c 添加到容器中
   }
 
public static void main(String[] args) {
GUISeeknum mygb =new GUISeeknum(); 
mygb.setSize(600,400);
mygb.setVisible(true);
}
}
