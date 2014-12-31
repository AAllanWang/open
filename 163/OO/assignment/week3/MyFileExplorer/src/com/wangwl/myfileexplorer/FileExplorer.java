package com.wangwl.myfileexplorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class FileExplorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("My Explorer");
//		
//		JToolBar toolBar = new JToolBar("JToolBar");
//		toolBar.setFloatable(false);
//		JButton upBtn = new JButton("Up");
//		toolBar.add(upBtn);
//		JTextArea textArea = new JTextArea();   
//		//textArea.setEditable(false);
//		toolBar.add(textArea);
//		upBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		frame.add(toolBar, BorderLayout.PAGE_START);
//			
//		
//		frame.getContentPane().add(new GUI());
//		frame.pack();
//		
//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//		int left = (screen.width - frame.getWidth()) / 2;
//		int top = (screen.height - frame.getHeight()) / 2;
//		frame.setLocation(left, top);
//		frame.setVisible(true);
		new GUI_1("My Explorer").init();
	}
}
class GUI_1 extends JFrame implements ActionListener {
	static final int LEFT_WIDTH = 200;
	static final int RIGHT_WIDTH = 300;
	static final int WINDOW_HEIGHT = 300;
	private JPanel panel;
	private FileList filelist;
	private FileTree filetree;
	
	public GUI_1(String title){
		panel = new JPanel();
		filelist = new FileList();
		filetree = new FileTree(filelist);
		setTitle(title);
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initToolBar();
		initCompents();
	}
	
	private void initToolBar(){
		JToolBar toolBar = new JToolBar("JToolBar");
		toolBar.setFloatable(false);
		JButton upBtn = new JButton("Up");
		toolBar.add(upBtn);
		upBtn.addActionListener(this);	
		add(toolBar,BorderLayout.PAGE_START);
	}
	
	private void initCompents(){
		panel.setPreferredSize(new Dimension(800,600));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel.setLayout(new BorderLayout());
		
		filelist.setDoubleBuffered(true);
		filetree.setDoubleBuffered(true);

		JScrollPane treeView = new JScrollPane(filetree);
		treeView.setPreferredSize(new Dimension(LEFT_WIDTH, WINDOW_HEIGHT));
		JScrollPane listView = new JScrollPane(filelist);
		listView.setPreferredSize(new Dimension(RIGHT_WIDTH, WINDOW_HEIGHT));

		JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView,listView);

		splitpane.setDividerLocation(300);
		splitpane.setDividerSize(4);
		splitpane.setDoubleBuffered(true);
		panel.add(splitpane);
		
		getContentPane().add(panel);
		pack();
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int left = (screen.width - getWidth()) / 2;
		int top = (screen.height - getHeight()) / 2;
		setLocation(left, top);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(filelist != null){
			if(filelist.getNode()!=null){
				File file = filelist.getNode().getFile();
				if(file.getParentFile()!=null){
					filelist.setNode(new FileNode(file.getParentFile()));
				}
			}
		}
	}
}

class GUI extends JPanel {
	static final int LEFT_WIDTH = 200;
	static final int RIGHT_WIDTH = 300;
	static final int WINDOW_HEIGHT = 300;

	public GUI() {
		setPreferredSize(new Dimension(800,600));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new BorderLayout());

		FileList list = new FileList();
		FileTree tree = new FileTree(list);
		
		tree.setDoubleBuffered(true);
		list.setDoubleBuffered(true);

		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(LEFT_WIDTH, WINDOW_HEIGHT));
		JScrollPane listView = new JScrollPane(list);
		listView.setPreferredSize(new Dimension(RIGHT_WIDTH, WINDOW_HEIGHT));

		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView,listView);

		pane.setDividerLocation(300);
		pane.setDividerSize(4);
		pane.setDoubleBuffered(true);
		add(pane);
	}
}
