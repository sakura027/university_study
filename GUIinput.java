package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JLabel;
public class GUIinput extends Frame implements ActionListener{
Frame my;
private int a=0;
private JLabel l1,l2,l3,l4,l5,l6;
private TextField tf1,tf2,tf3,tf4,tf5,tf6;
private JButton btn1,btn2,b1;
private GridBagLayout gb;
private GridBagConstraints gbc;
private String ac="",a2;
private int a1, a3,a4,a5,a6,sum,aver;

public GUIinput() {
l1=new JLabel("      学号  ");
l2=new JLabel("      姓名  ");
l3=new JLabel("高等数学");
l4=new JLabel("程序设计");
l5=new JLabel("软件工程");
l6=new JLabel("离散数学");
tf1=new TextField(20);
tf1.setText("");
tf2=new TextField(20);
tf3=new TextField(20);
tf4=new TextField(20);
tf5=new TextField(20);
tf6=new TextField(20);
gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
btn1=new JButton("提交"); //初始化按钮 btn1 
btn2=new JButton("退出"); 
btn1.addActionListener(this);
btn2.addActionListener(this);
 
Panel p0 = new Panel(); //创建，并初始化面板 p1 
p0.add(btn1); 
p0.add(btn2);
Panel p1 = new Panel();
p1.add(l1);
p1.add(tf1);
Panel p2 = new Panel();
p2.add(l2);
p2.add(tf2);
Panel p3 = new Panel();
p3.add(l3);
p3.add(tf3);
Panel p4 = new Panel();
p4.add(l4);
p4.add(tf4);
Panel p5 = new Panel();
p5.add(l5);
p5.add(tf5);
Panel p6 = new Panel();
p6.add(l6);
p6.add(tf6);
 
addWindowListener(new WindowAdapter(){ 
public void windowClosing(WindowEvent e){
     setVisible(false);
     dispose();
System.exit(0); //程序退出
} 
}); 
 
gbc.fill=GridBagConstraints.HORIZONTAL; //设置 gbc 的 fill 域
 
addComponent(p1,0, 2, 1, 1);
addComponent(p2,2, 2, 1, 1);
addComponent(p3,3, 2, 1, 1);
addComponent(p4,4, 2, 1, 1); 
addComponent(p5,5, 2, 1, 1);
addComponent(p6,6, 2, 1, 1);
addComponent(p0,9, 2, 1, 1); 
}
//********************************************************************************8
public void gui() {
my=new Frame();
my.setBounds(300,300,350,250);
my.setLayout(null);
my.setVisible(true); 
b1=new JButton("返回");
b1.addActionListener(this);
JLabel a1=new JLabel("该学生已存在！ ");
JLabel a2=new JLabel("添加成功！");
JLabel a3=new JLabel("输入为空！");
if(a==1) {
my.add(a1);
a1.setBounds(140,100,100,40);
} 
else if(a==0) {
my.add(a2);
a2.setBounds(140,100,100,40);
}
else if(a==2) {
my.add(a3);
a3.setBounds(140,100,100,40);
}
my.add(b1); 
b1.setBounds(230,190,80,30);
my.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent evt) {
my.setVisible(false);
my.dispose();
} 
});
}
//******************************************************************************************************
public void actionPerformed(ActionEvent e) {
if(e.getSource()==btn1) {

ac=tf1.getText();
    if(ac.equals(""))
    a=2;
    else {
    a=0;
a1=Integer.parseInt(tf1.getText());
a2=tf2.getText();
a3=Integer.parseInt(tf3.getText() );
a4=Integer.parseInt(tf4.getText() );
a5=Integer.parseInt(tf5.getText() );
a6=Integer.parseInt(tf5.getText() );
    sum=a3+a4+a5+a6;   //总成绩
    aver=sum/4;    //平均成绩
      
    SQL bd=new SQL();
Connection conn=bd.getConn();
    try {
    Statement stmt = conn.createStatement(); //创建Statement对象
    try {
        String sql = "INSERT INTO `score_management`.`student` (`id`, `name`, `math`, `program`, `software`, `math2`, `aver`, `sum`) VALUES  (?,?,?,?,?,?,?,?)"; //要执行的SQL
        PreparedStatement pst = conn.prepareStatement(sql);                             //传入带占位符的SQL语句
pst.setInt(1,a1);        
pst.setString(2,a2);
pst.setInt(3,a3);
pst.setInt(4,a4);
pst.setInt(5,a5);
pst.setInt(6,a6);
pst.setInt(7,aver);
pst.setInt(8,sum);
pst.executeUpdate(); //执行 update和insert、delete等sql语句
pst.close();
    }catch(SQLIntegrityConstraintViolationException e1) {
    a=1;
    }
        stmt.close();
        conn.close();
    }catch(SQLException e2){
    e2.printStackTrace();
    }
    }
    
    gui();
}else if(e.getSource()==btn2) {
setVisible(false);
dispose();
}else if(e.getSource()==b1) {
my.setVisible(false);
my.dispose();
}
}
//*******************************************************************************************
public void addComponent(Component c,int row,int col, int nrow,int ncol){ 
gbc.gridx=col; //设置组件显示区域的开始边单元格
gbc.gridy=row; //设置组件显示区域的顶端单元格
gbc.gridheight=ncol; //设置组件显示区域一列的单元格数
gbc.gridwidth=nrow; //设置组件显示区域一行的单元格数
gb.setConstraints(c,gbc); //设置布局的约束条件
add(c); //组件 c 添加到容器中
        }
//******************************入口***********************************************************	 
public static void main(String[] args) {
GUIinput mygb =new GUIinput(); 
mygb.setSize(600,400);
mygb.setVisible(true);
}
}
