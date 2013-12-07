package Mafia;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {

	private Model _model;
	
	public GamePane gamePanel;
	public ChatPane chatPanel;
	public CardPane cardPanel;
	public JTextField message;
	public JButton send;
	public Container c;
	public JTextArea memo;
	public JScrollPane scrollBar;
	
	public View(Model m)
	{
		_model=m;
		
		//setting sizes
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) dim.getWidth();
        int screenHeight = (int) dim.getHeight();
        this.setSize(screenWidth,screenHeight);
        
        //setting elements
        c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		
		memo=new JTextArea(20,50);
		scrollBar = new JScrollPane(memo);
		
		send=new JButton("���������");
		message=new JTextField(40);
		
		gamePanel=new GamePane();
		chatPanel=new ChatPane();
		cardPanel=new CardPane();
		JPanel grouping =new JPanel();
		
		chatPanel.setBackground(Color.LIGHT_GRAY);
		gamePanel.setBackground(new Color(234,212,124));
		cardPanel.setBackground(Color.GRAY);
		
		chatPanel.add(scrollBar);
		chatPanel.add(message);
		chatPanel.add(send);
		
		
		grouping.setLayout(new GridLayout(1,2));
        grouping.add(cardPanel);
        grouping.add(chatPanel);
		
		
		c.add(gamePanel);
		c.add(grouping);
		

	}
	
	public void update()
	{
		
	}

}


class GamePane extends JPanel
{
	public GamePane()
	{
		
	}
}



class ChatPane extends JPanel
{
	
	
	public ChatPane()
	{
		
	}
}

class CardPane extends JPanel
{
	
	
	public CardPane()
	{
		
	}
}