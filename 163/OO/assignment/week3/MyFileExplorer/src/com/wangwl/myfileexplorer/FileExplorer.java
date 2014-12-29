package com.wangwl.myfileexplorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class FileExplorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Explorer");
		frame.getContentPane().add(new GUI());
		frame.pack();
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int left = (screen.width - frame.getWidth()) / 2;
		int top = (screen.height - frame.getHeight()) / 2;
		frame.setLocation(left, top);
		frame.setVisible(true);
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
