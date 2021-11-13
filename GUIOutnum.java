package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GUIOutnum extends Frame implements ActionListener{
private double sum,max,min;
private String s;
private TextArea m1;
Frame c1,c2;
private JButton b1,b2,b3,b4,b5;
private GridBagLayout gb;
private GridBagConstraints gbc;
public GUIOutnum() {
gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
b1=new JButton("               总体排名                "); //初始化按钮 btn1 
b2=new JButton("      科目成绩        "); 
b3=new JButton("        返回         ");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
addWindowListener(new WindowAdapter(){ 
public void windowClosing(WindowEvent e){
     setVisible(false);
     dispose();
System.exit(0); //程序退出
} 
});  
gbc.fill=GridBagConstraints.HORIZONTAL;//设置 gbc 的 fill 域horizontal
addComponent(b1,0, 2, 1, 2);
addComponent(b2,2, 2, 1, 2);
addComponent(b3,4, 2, 1, 2);
}
public void addComponent(Component c,int row,int col, int nrow,int ncol){ 
gbc.gridx=col; //设置组件显示区域的开始边单元格
gbc.gridy=row; //设置组件显示区域的顶端单元格
gbc.gridheight=ncol; //设置组件显示区域一列的单元格数
gbc.gridwidth=nrow; //设置组件显示区域一行的单元格数
gb.setConstraints(c,gbc); //设置布局的约束条件
add(c); //组件 c 添加到容器中
   }
 
public void actionPerformed(ActionEvent e) {
if(e.getSource()==b1) {
//*********总体排名**********
c2=new JFrame();
c2.setBounds(600,130,500,750);
c2.setLayout(null);
c2.setVisible(true); 
b5=new JButton("返回");
b5.addActionListener(this);
c2.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent evt) {
c2.setVisible(false);
c2.dispose();
}
});
SQL bd=new SQL();
Connection conn=bd.getConn(); 
int a=1;
       try {
        //数据库
        Statement stmt;
        stmt = conn.createStatement();
        String sql="select id,name,aver from student order by aver desc;";
        ResultSet rs = stmt.executeQuery(sql);
        s="排 名"+"\t"+"学号"+"\t"+"  姓名"+"\t\t"+"平 均 成 绩"+"\n";
        while(rs.next()) {
        s=s+"\n\n"+" "+a+"        "+rs.getString("id")+"        "+rs.getString("name")+"                "+rs.getDouble("aver");
        a++;
        }
        m1=new TextArea(s);
        m1.setEditable(false);
        m1.setBounds(50,50,400,550);
        c2.add(m1);
        b5.setBounds(380,690,80,30);
        c2.add(b5);
       
        rs.close();
        stmt.close();
            conn.close();
        }catch(Exception e1){
        e1.printStackTrace();
        }
        
}else if(e.getSource()==b2) {
//********科目成绩***********
c1=new JFrame();
c1.setBounds(300,300,450,450);
c1.setLayout(null);
c1.setVisible(true);
JLabel a1,a2,a3,a4,a5;
a1=new JLabel("                  平均成绩      最高成绩       最低成绩");
b4=new JButton("返回");
b4.addActionListener(this);
c1.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent evt) {
c1.setVisible(false);
c1.dispose();
}
});
SQL bd=new SQL();
Connection conn=bd.getConn(); 
try {
Statement stmt = conn.createStatement(); //创建Statement对象
int i=0;
String sql = "select math from student order by math desc;";    //要执行的SQL
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
        sum=sum+rs.getInt("math");
        i++;
        if(rs.isFirst())
        max=rs.getInt("math");
        if(rs.isLast())
        min=rs.getInt("math");
        }
        sum=sum/i;//平均成绩
        a2=new JLabel("高等数学成绩：           "+String.format("%.2f", sum)+"              "+max+"                "+min);
        
        i=0;
        sum=0.0;
String sql1 = "select program from student order by program desc;";    //要执行的SQL
        ResultSet rs1 = stmt.executeQuery(sql1);
        while(rs1.next()) {
        sum=sum+rs1.getInt("program");
        i++;
        if(rs1.isFirst())
        max=rs1.getInt("program");
        if(rs1.isLast())
        min=rs1.getInt("program");
        }
        sum=sum/i; //平均成绩
        a3=new JLabel("程序设计成绩：           "+String.format("%.2f", sum)+"              "+max+"               "+min);
        
        i=0;
        sum=0.0;
        //数据库
String sql2 = "select software from student order by software desc;";    //要执行的SQL
        ResultSet rs2 = stmt.executeQuery(sql2);
        while(rs2.next()) {
        sum=sum+rs2.getInt("software");
        i++;
        if(rs2.isFirst())
        max=rs2.getInt("software");
        if(rs2.isLast())
        min=rs2.getInt("software");
        }
        sum=sum/i;//平均成绩
       a4=new JLabel("软件工程成绩：           "+String.format("%.2f", sum)+"              "+max+"                "+min);
        
        i=0;
        sum=0.0;
String sql3 = "select math2 from student order by math2 desc;";    //要执行的SQL
        ResultSet rs3 = stmt.executeQuery(sql3);
        while(rs3.next()) {
        sum=sum+rs3.getInt("math2");
        i++;
        if(rs3.isFirst())
        max=rs3.getInt("math2");
        if(rs3.isLast())
        min=rs3.getInt("math2");
        }
        sum=sum/i;                //平均成绩
        a5=new JLabel("离散数学成绩：           "+String.format("%.2f", sum)+"              "+max+"                "+min);
        
        a1.setBounds(70,20,300,60);// 距左边的距离   距顶部的距离   长度  高度
a2.setBounds(10, 70,300,50);
a3.setBounds(10, 110, 300,50);
a4.setBounds(10, 150, 300,50);
a5.setBounds(10, 190, 300,50);
b4.setBounds(300, 360, 100,40);
c1.add(a1);
c1.add(a2);
c1.add(a3);
c1.add(a4);
c1.add(a5);
c1.add(b4);
        rs.close();
        rs1.close();
        rs2.close();
        rs3.close();
        stmt.close();
        conn.close();
}catch(SQLException e1) {
e1.printStackTrace();
}
}else if(e.getSource()==b3) {
setVisible(false);
dispose();
}else if(e.getSource()==b4) {
c1.setVisible(false);
c1.dispose();
}else if(e.getSource()==b5) {
c2.setVisible(false);
c2.dispose();
}
}
public static void main(String[] args) {
GUIOutnum mygb=new GUIOutnum();
mygb.setSize(700,500);
mygb.setVisible(true);
}
}
