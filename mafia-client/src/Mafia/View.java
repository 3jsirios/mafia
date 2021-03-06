package Mafia;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class View extends JFrame {

	public static Model _model;
	
	public static GamePane gamePanel;
	public ChatPane chatPanel;
	public CardPane cardPanel;
	public JTextField message;
	public JButton send,active;
	public Container c;
	public static JTextArea memo;
	public JScrollPane scrollBar;
	public static JLabel card;
	public static Map<String, Card> cards = new HashMap<String, Card>();
	
	
	
	public Timer time;
	
	public View(Model m)
	{
		_model=m;
		
		//setting sizes
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) 700;
        int screenHeight = (int) 700;
        this.setSize(screenWidth,screenHeight);
        
        //setting elements
        c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		
		memo=new JTextArea(15,30);
		scrollBar = new JScrollPane(memo);
		
		send=new JButton("Send");
		active=new JButton("Active");
		card=new JLabel();
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
		
		cardPanel.add(card);
		cardPanel.add(active);
		
		
		gamePanel.setLayout(new GridLayout(3,3));
		
		grouping.setLayout(new GridLayout(1,2));
        grouping.add(cardPanel);
        grouping.add(chatPanel);
        
		
		c.add(gamePanel);
		c.add(grouping);
				

	}
	

	
	public static void addCard(Map<String, String> user) {
		cards.put(user.get("userid"), new Card(gamePanel, user));
		gamePanel.setSize(gamePanel.getSize());
	}

	
}



class Card extends JPanel
{
	JButton btn = new JButton("make action");
	JButton vote = new JButton("Vote against");
	String username;
	public Card(JPanel parent, Map<String, String>  user)
	{	
		username = user.get("username");
		setLayout(new GridLayout(1,2));

		
		String path = "suit.jpg";
		URL imgURL = Main.class.getResource(path);
		ImageIcon icon = new ImageIcon(imgURL);

		JLabel l=new JLabel();
		l.setIcon(icon);
		add(l);
		add(new JLabel(user.get("username")));
		if (!View._model.user_role.equals("civilian")) {
			addAction(btn, user.get("userid"));
			add(btn);
		}
		vouting(vote,user.get("username"));
		
		vote.setEnabled(false);
		add(vote);

		parent.add(this);
	}
	
	void vouting(Object obj, final String userid) {
		vote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("action", "vote");
				m.put("userfrom",View._model.user_id );
				m.put("userto", userid );
				Main.c.enableVoteButtons(false);	
				
			}
		});
	}
	
	void addAction(Object obj, final String userid){
		
		
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {		
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("action", "game-action");
					m.put("userfrom",View._model.user_id );
					m.put("userto", userid );
					
					View._model.sendMessage(m);
					Main.c.enableCards(false);
					
			}

	}
		
	);
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
