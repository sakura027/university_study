package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.sql.rowset.serial.SerialArray;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUImain extends JFrame implements ActionListener {
    ImageIcon background;
    private JButton b1, b2, b3, b4;
    private JLabel a1, a2,label;
    private GridBagLayout gb;
    private GridBagConstraints gbc;
   JPanel myPanel;
 
    GUImain(){
        background = new ImageIcon("D:\\WORKTOOL\\NetBeans\\软工\\JavaApplication1\\image\\p1.png");
        //创建一个背景图片                
		label = new JLabel(background);	
                label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
        myPanel = (JPanel)this.getContentPane();
        myPanel.setOpaque(false);
        this.getLayeredPane().setLayout(null);	
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        a1 = new JLabel("    欢迎使用学生成绩管理系统");
        a1.setFont(new Font(null, Font.LAYOUT_RIGHT_TO_LEFT, 20));
        a2 = new JLabel(" ");
        gb = new GridBagLayout(); //初始化 gb 
        setLayout(gb); //设置窗口布局管理器 gb 
        gbc = new GridBagConstraints(); //初始化网格包容器
        b1 = new JButton("成绩管理"); //初始化按钮 btn1 
        b2 = new JButton("查询成绩");
        b3 = new JButton("输出成绩");
        b4 = new JButton("退出系统");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0); //程序退出
            }
        }); 
        gbc.fill = GridBagConstraints.HORIZONTAL; //设置 gbc 的 fill 域
        addComponent(a1, 0, 3, 1, 2);
        addComponent(b1, 4, 3, 1, 2);
        addComponent(b2, 6, 3, 1, 2);
//        addComponent(b3, 10, 2, 1, 2);
        addComponent(b4, 8, 3, 1, 2);
 
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "成绩管理") {
            GUImanagement mygb =new GUImanagement(); 
            mygb.setSize(600,400);
            mygb.setVisible(true);
        } else if (e.getActionCommand() == "查询成绩") {
            GUISeeknum mygb = new GUISeeknum();
            mygb.setSize(600, 400);
            mygb.setVisible(true);
        } 
        else if (e.getActionCommand() == "输出成绩") {
            GUIOutnum mygb = new GUIOutnum();
            mygb.setSize(700, 500);
            mygb.setVisible(true);
        }
        else if (e.getActionCommand() == "退出系统") {
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }
 
    public void addComponent(Component c, int row, int col, int nrow, int ncol) {
        gbc.gridx = col; //设置组件显示区域的开始边单元格
        gbc.gridy = row; //设置组件显示区域的顶端单元格
        gbc.gridheight = ncol; //设置组件显示区域一列的单元格数
        gbc.gridwidth = nrow; //设置组件显示区域一行的单元格数
        gb.setConstraints(c, gbc); //设置布局的约束条件
        add(c); //组件 c 添加到容器中
    }

    public static void main(String[] args) {
        GUImain mygb = new GUImain();
        mygb.setSize(717, 535);
        mygb.setVisible(true);
    }
}
