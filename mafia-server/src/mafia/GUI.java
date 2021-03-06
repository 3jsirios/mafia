package mafia;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.*;



public class GUI extends JFrame {


	JButton start,stop;
	public static Container c;
	public static JTextArea memo;
	public JScrollPane scrollBar;
	
	public GUI() {

		//setting sizes
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) 700;
		int screenHeight = (int) 200;
		setSize(screenWidth,screenHeight);
		
		 //setting elements
        c=this.getContentPane();
		c.setLayout(new GridLayout(2,2));
		
		memo=new JTextArea(20,60);
		scrollBar = new JScrollPane(memo);
		
		start=new JButton("Start server");
		stop=new JButton("Stop server");
		
		JPanel chatPanel=new JPanel();
		JPanel actionPanel=new JPanel();
		
		chatPanel.add(scrollBar);
		actionPanel.add(start);
		actionPanel.add(stop);
		
		c.add(chatPanel);
		
		c.add(actionPanel);
	}
	
	public static void println(String str) {
		memo.append(str);
		memo.append("\n");
	}
	
	

}
