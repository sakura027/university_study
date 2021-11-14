package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JLabel;
public class GUIchange extends Frame implements ActionListener{
Frame my; 
String b;
private JLabel a1,a3,an;
private JButton b1,b2,b3,b4,be;
private TextField c1,c3;
private GridBagLayout gb;
private GridBagConstraints gbc;
public GUIchange() {
	my=new Frame(); 
	my.setBounds(300,300,350,250);
	my.setLayout(null);
	my.setVisible(false); 

	JLabel an=new JLabel("插入成功！ ");
		my.add(an);
		an.setBounds(140,100,100,40);
	my.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent evt) {
		my.setVisible(false);
		my.dispose();
		} });
	
	
a1=new JLabel("请输入学生学号：        ");
c1=new TextField(20);
a3=new JLabel("请输入要修改的成绩： ");
c3=new TextField(20);

gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
b1=new JButton("修改高等数学"); //初始化按钮 btn1 
b2=new JButton("修改程序设计"); 
b3=new JButton("修改软件工程");
b4=new JButton("修改离散数学");
be=new JButton("退出");
 
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
be.addActionListener(this);
Panel p0 = new Panel(); //创建，并初始化面板 p1 
p0.add(a1); 
p0.add(c1);
Panel p2 = new Panel();
p2.add(a3); 
p2.add(c3);

 

Panel p1 = new Panel();
p1.add(b1);
p1.add(b2);
Panel p3 = new Panel();
p3.add(b3); 
p3.add(b4); 
p3.add(be);
addWindowListener(new WindowAdapter(){ 
public void windowClosing(WindowEvent e){
     setVisible(false);
     dispose();
System.exit(0); //程序退出
} 
});   
  
gbc.fill=GridBagConstraints.HORIZONTAL; //设置 gbc 的 fill 域
addComponent(p0,0, 2, 1, 1);
addComponent(p2,4, 2, 1, 1);
addComponent(p1,6, 2, 1, 1); 
addComponent(p3,8, 2, 1, 1); 




}
public void actionPerformed(ActionEvent e) {


if(e.getSource()==b1) {        
    int id,score;
    id=Integer.parseInt(c1.getText());	
    score=Integer.parseInt(c3.getText());
	  SQL bd=new SQL();
	  Connection conn=bd.getConn();
	      try {
	      Statement stmt = conn.createStatement(); //创建Statement对象
	      try {
	          String sql = "UPDATE `score_management`.`student` SET `math` = ? WHERE `id` = ?; "; //要执行的SQL
	          PreparedStatement pst = conn.prepareStatement(sql);                           
			  pst.setInt(1,score);        	 
			  pst.setInt(2,id);	  
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
    
	 
}else if(e.getSource()==b2) {      
	 int id,score;
	    id=Integer.parseInt(c1.getText());	
	    score=Integer.parseInt(c3.getText());
		  SQL bd=new SQL();
		  Connection conn=bd.getConn();
		      try {
		      Statement stmt = conn.createStatement(); //创建Statement对象
		      try {
		          String sql = "UPDATE `score_management`.`student` SET `program` = ? WHERE `id` = ?; "; //要执行的SQL
		          PreparedStatement pst = conn.prepareStatement(sql);                           
				  pst.setInt(1,score);        	 
				  pst.setInt(2,id);	  
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

}else if(e.getSource()==b3) {  
	 int id,score;
	    id=Integer.parseInt(c1.getText());	
	    score=Integer.parseInt(c3.getText());
		  SQL bd=new SQL();
		  Connection conn=bd.getConn();
		      try {
		      Statement stmt = conn.createStatement(); //创建Statement对象
		      try {
		          String sql = "UPDATE `score_management`.`student` SET `software` = ? WHERE `id` = ?; "; //要执行的SQL
		          PreparedStatement pst = conn.prepareStatement(sql);                           
				  pst.setInt(1,score);        	 
				  pst.setInt(2,id);	  
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

}else if(e.getSource()==b4) {   
	 int id,score;
	    id=Integer.parseInt(c1.getText());	
	    score=Integer.parseInt(c3.getText());
		  SQL bd=new SQL();
		  Connection conn=bd.getConn();
		      try {
		      Statement stmt = conn.createStatement(); //创建Statement对象
		      try {
		          String sql = "UPDATE `score_management`.`student` SET `math2` = ? WHERE `id` = ?; "; //要执行的SQL
		          PreparedStatement pst = conn.prepareStatement(sql);                           
				  pst.setInt(1,score);        	 
				  pst.setInt(2,id);	  
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

}else if(e.getActionCommand()==be.getActionCommand()) {
	setVisible(false);
    dispose();
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
GUIchange mygb =new GUIchange(); 
mygb.setSize(600,400);
mygb.setVisible(true);
}
}