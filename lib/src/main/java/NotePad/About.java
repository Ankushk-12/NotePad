package NotePad;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
	About(){
		
		setBounds(400,100,600,500);
		setLayout(null);
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/windows.png"));
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
		Image l2 = icon.getImage().getScaledInstance(300, 60, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel label = new JLabel(l3);
		label.setBounds(70, 40, 400, 60);
		add(label);
		
		Image l4 = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon note = new ImageIcon(l4);
		JLabel label2 = new JLabel(note);
		label2.setBounds(50,150,70,70);
		add(label2);
		
		Image img = icon1.getImage();
		setIconImage(img);
		setTitle("Notepad");
		
		JLabel text = new JLabel("<html>Microsoft Windows <br> Version 1.0. (OS build java) <br> Microsoft Corporation. All rights reserved <br></html>");
		text.setBounds(160,139,350,100);
		add(text);
		
		JLabel text2 = new JLabel("<html>The Windows 10 Home Single Language operating System and its  user<br> interface are protected by trademark and other pending or existing"
				+ "<br> intellectual property rights in the United States and other counteries/regions</html>");
		text2.setBounds(160,235,350,100);
		add(text2);
		JLabel text3 = new JLabel("<html> This product is licensed under <u> Code with Ankush </u></html>");
		text3.setBounds(160,310,350,100);
		add(text3);
		JButton button = new JButton("OK");
		button.setBounds(480,400,80,25);
		button.addActionListener(this);
		add(button);
		
		setVisible(true); // Make shore it is the last line 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new About();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
