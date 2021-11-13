package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javaapplication1.SQL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GUIselect extends Frame implements ActionListener{
private double sum,max,min;
private String s;
private TextArea m1;
Frame c1,c2;
private JButton b1,b2,b3,b4,b5;
private GridBagLayout gb;
private GridBagConstraints gbc;
public GUIselect() {
gb=new GridBagLayout(); //初始化 gb 
setLayout(gb); //设置窗口布局管理器 gb 
gbc=new GridBagConstraints(); //初始化网格包容器
b1=new JButton("               添加 / 修改 成绩                "); //初始化按钮 btn1 
b2=new JButton("      删除指定学生信息        "); 
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
 GUIinput mygb =new GUIinput(); 
            mygb.setSize(600,400);
            mygb.setVisible(true);
}else if(e.getSource()==b2) {

}else if(e.getActionCommand()==b3.getActionCommand()) {
    setVisible(false);
     dispose();
}
}
public static void main(String[] args) {
GUIselect mygb=new GUIselect();

mygb.setSize(700,500);
mygb.setVisible(true);
}
}
