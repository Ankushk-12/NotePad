package NotePad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePad implements ActionListener {
	int size = 18;
	String text;
	JFrame f = new JFrame();
	JTextArea area;
	NotePad(){
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); // responsive page for different screens 
		
		f.setTitle("Notepad");
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
		Image icon = imageIcon.getImage();
		f.setIconImage(icon);
		
		JMenuBar menubar = new JMenuBar();  // creating menu bar
		menubar.setBackground(Color.white);
		JMenu file = new JMenu("FIle");  // creating Menu
		file.setFont(new Font("Arial",Font.PLAIN,14));
		
		JMenuItem newItem = new JMenuItem("New");
		newItem.addActionListener(this);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));  // Press Ctrl+N to create new Txt file
		
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(this);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));  // Press Ctrl+O to  Open Existing Txt file
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(this);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));  // Press Ctrl+S to Save Txt file
		
		JMenuItem print = new JMenuItem("Print");
		print.addActionListener(this);
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));  // Press Ctrl+P to Print Txt file
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK));  // Press esc to exit the notepad
		
		file.add(newItem);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		menubar.add(file);  // adding menu to menu-bar
		
		JMenu edit = new JMenu("Edit");  // creating Menu
		edit.setFont(new Font("Arial",Font.PLAIN,14));
		
		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(this);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));  // Press Ctrl+X to cut the text
		
		JMenuItem copy = new JMenuItem("Copy");
		copy.addActionListener(this);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));  // Press Ctrl+C to  Copy the text
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(this);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));  // Press Ctrl+V to paste the text
		
		JMenuItem selectAll = new JMenuItem("Select All");
		selectAll.addActionListener(this);
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));  // Press Ctrl+A to Select the all the text
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		menubar.add(edit);  // adding menu to menu-bar
		
		JMenu viewMenu = new JMenu("View");  // creating View
		viewMenu.setFont(new Font("Arial",Font.PLAIN,14));

		JMenu zoomMenu = new JMenu("Zoom");  // creating Zoom sub-menu
		zoomMenu.setFont(new Font("Arial",Font.PLAIN,14));
		JMenuItem zoomIn = new JMenuItem("Zoom In");
		zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK));
		zoomIn.addActionListener(this);
		zoomMenu.add(zoomIn);
		JMenuItem zoomOut = new JMenuItem("Zoom Out");
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
		zoomOut.addActionListener(this);
		zoomMenu.add(zoomOut);
		JMenuItem zoomDefault = new JMenuItem("Zoom Default");
		zoomDefault.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
		zoomDefault.addActionListener(this);
		zoomMenu.add(zoomDefault);
		viewMenu.add(zoomMenu);
		menubar.add(viewMenu);
		JMenu helpMenu = new JMenu("Help");  // creating Menu
		helpMenu.setFont(new Font("Arial",Font.PLAIN,14));
		
		JMenuItem help = new JMenuItem("About");
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));  // Press Ctrl+X to cut the text
		help.addActionListener(this);
		helpMenu.add(help);
		menubar.add(helpMenu);
		 area = new JTextArea();
		 area.setFont(new Font("SAN_SERIF",Font.PLAIN,size));
		 area.setLineWrap(true); // Go to next line when achieve max length of the screen
		 area.setWrapStyleWord(true); // Move to next Line when Word length is grater than space remaining 
//		 add(area);
		 
		 JScrollPane pane = new JScrollPane(area);
		 pane.setBorder(BorderFactory.createEmptyBorder());
		 f.add(pane);
		 
		f.setJMenuBar(menubar);   //adding Menu-bar to the JFrame
		f.setVisible(true); // make shore to make it last statement
	}

	public static void main(String[] args) {
		new NotePad();
//		new NotePad();  // it is called enormous Object

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("New")) {
			area.setText("");
			f.setTitle("Untittled - Notepad");
		}else if(e.getActionCommand().equals("Open")) {
			JFileChooser choose = new JFileChooser();
			
			choose.setAcceptAllFileFilterUsed(false);
			
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Choose only .txt files","txt"); // Restrict the files to be open
			
			choose.addChoosableFileFilter(restrict); // added the restricted files
			int action = choose.showOpenDialog(f);
			
			if(action != JFileChooser.APPROVE_OPTION) {   // Is file choose or not 
				return;
			}else {
				File file = choose.getSelectedFile();  // going to add file to notepad
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					f.setTitle(file.getName()+" Notepad ");
					area.read(reader, null);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Save")) {
			
			JFileChooser saveAs = new JFileChooser();
			
			saveAs.setApproveButtonText("Save");
			saveAs.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Text Document ","txt"); // Restrict the files to be open
			
			saveAs.addChoosableFileFilter(restrict); // added the restricted files
			int action = saveAs.showOpenDialog(f);
			if(action != JFileChooser.APPROVE_OPTION) {
				return;
			}else {
				File save = (saveAs.getSelectedFile());
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(save));
					f.setTitle(save.getName()+" Notepad ");
					area.write(writer);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("Print")) {
			try {
				area.print();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
		// Edit Menu-Item
		
		else if(e.getActionCommand().equals("Cut")) {
			area.replaceRange(text, area.getSelectionStart(), area.getSelectionEnd());
		}
		else if(e.getActionCommand().equals("Copy")) {
			text = area.getSelectedText();
		}
		else if(e.getActionCommand().equals("Paste")) {
			area.insert(text, area.getCaretPosition());
		}
		else if(e.getActionCommand().equals("Select All")) {
			area.selectAll();
		}
		else if(e.getActionCommand().equals("About")) {
			new About().setVisible(true);
		}

		else if(e.getActionCommand().equals("Zoom In")){
			int zoomIn = size+2;
			area.setFont(new Font("SAN_SERIF",Font.PLAIN,zoomIn));
			size = zoomIn;
		}
		else if(e.getActionCommand().equals("Zoom Out")){
			if(size >15){
				int zoomOut = size-2;
				area.setFont(new Font("SAN_SERIF",Font.PLAIN,zoomOut));
				size = zoomOut;
			}
		}
		else if(e.getActionCommand().equals("Zoom Default")){
			int deafult = 18;
			area.setFont(new Font("SAN_SERIF",Font.PLAIN,deafult));
			size = deafult;
		}
		
	}

}
