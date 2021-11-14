package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JLabel;
public class GUIdelete extends Frame implements ActionListener{
Frame my;
int b;
private JLabel a1,a2;
private JButton b1,b2;
private TextField c1;
private GridBagLayout gb;
private GridBagConstraints gbc;
public GUIdelete() {
a1=new JLabel("请输入要删除学生的学号： ");
c1=new TextField(20);

my=new Frame(); 
my.setBounds(300,300,350,250);
my.setLayout(null);
my.setVisible(false); 

JLabel an=new JLabel("删除成功！ ");
	my.add(an);
	an.setBounds(140,100,100,40);
my.addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent evt) {
	my.setVisible(false);
	my.dispose();
	} });



gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
b1=new JButton("确定"); //初始化按钮 btn1 
b2=new JButton("退出"); 
b1.addActionListener(this);
b2.addActionListener(this);
Panel p0 = new Panel(); //创建，并初始化面板 p1 
p0.add(a1); 
p0.add(c1);
p0.add(a2);
a2.setVisible(false);
Panel p1 = new Panel();
p1.add(b1); 
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
if(e.getActionCommand()=="确定") {
b=Integer.parseInt(c1.getText());
SQL bd=new SQL();
Connection conn=bd.getConn();
    try {
    Statement stmt = conn.createStatement(); //创建Statement对象
    try {
        String sql = "DELETE FROM `score_management`.`student` WHERE `id` = ?; "; //要执行的SQL
        PreparedStatement pst = conn.prepareStatement(sql);                                 	 
		  pst.setInt(2,b);	  
		  pst.executeUpdate(); 
		  pst.close();
		  my.setVisible(true);
    }catch(SQLIntegrityConstraintViolationException e1) {
  	
  	    }
  	        stmt.close();
  	        conn.close();
  	    }catch(SQLException e2){
  	    e2.printStackTrace();
  	    }
    

}else if(e.getActionCommand()=="退出") {
     setVisible(false);
     dispose();
}else if(e.getActionCommand()=="返回") {
my.setVisible(false);
     my.dispose();
}
}public void addComponent(Component c,int row,int col, int nrow,int ncol){ 
gbc.gridx=col; //设置组件显示区域的开始边单元格
gbc.gridy=row; //设置组件显示区域的顶端单元格
gbc.gridheight=ncol; //设置组件显示区域一列的单元格数
gbc.gridwidth=nrow; //设置组件显示区域一行的单元格数
gb.setConstraints(c,gbc); //设置布局的约束条件
add(c); //组件 c 添加到容器中
   }
 
public static void main(String[] args) {
GUIdelete mygb =new GUIdelete(); 
mygb.setSize(600,400);
mygb.setVisible(true);
}
}