package mafia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;

public class Main {

	static final int PORT = 8080;
	public static boolean isPlaying = false;
	private static GUI _gui;
	public static void main(String[] args) throws IOException {
	
		ServerSocket s ; 
		s= new ServerSocket(PORT);
		
		//GUI interests
		_gui=new GUI();
		_gui.show();
		_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//
		
		System.out.println("Server Started");
		new MessagesSender();
		try {
			
			while (true) {
				// Останавливает выполнение, до нового соединения:
				Socket socket = s.accept();
				try {
					new User(socket);
					System.out.println("Usrer excepted");
				} catch (IOException e) {
					// Если неудача - закрываем сокет, в противном случае нить
					// закроет его:
					socket.close();
				}
			}
		} finally {
			s.close();
		}
	}

}
