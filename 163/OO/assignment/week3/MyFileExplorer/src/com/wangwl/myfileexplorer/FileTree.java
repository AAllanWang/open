package com.wangwl.myfileexplorer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class FileTree extends JPanel{
	private JTree tree;
	private FileList filelist;
	
	public FileTree(FileList fl){
		filelist = fl;

		File rootFile =FileSystemView.getFileSystemView().getHomeDirectory();
		FileNode rootFileNode= new FileNode(rootFile);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFileNode);
	
		File[] files = FileSystemView.getFileSystemView().getFiles(rootFile, true);
		for(int i = 0;i<files.length;i++){
			if(files[i].isDirectory()){
				root.add(new DefaultMutableTreeNode(new FileNode(files[i])));
			}
		}
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		//
		tree.setExpandsSelectedPaths(true);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				TreePath tp = tse.getNewLeadSelectionPath();
				Object o = tp.getLastPathComponent();
				final DefaultMutableTreeNode curNode =(DefaultMutableTreeNode)o; 
				final FileNode node = (FileNode) curNode.getUserObject();
				filelist.setNode(node);
				SwingUtilities.invokeLater(new Runnable() {   
					public void run() {
						File[] files = FileSystemView.getFileSystemView().getFiles(node.getFile(), true);
						for(int i = 0;i<files.length;i++){
							if(files[i].isDirectory()){
								curNode.add(new DefaultMutableTreeNode(new FileNode(files[i])));
							}
						}
						//tree.updateUI();
					}   
				}); 
				//System.out.println(o.toString());
			}
		});
		tree.setCellRenderer(new FileTreeRenderer());
		tree.setSelectionRow(0);

		setLayout(new BorderLayout());
		add(tree);
	}
	
}

class FileNode {
	private File file;
	public FileNode(File f){
		file = f;
	}
	public File getFile()
	{
		return file;
	}
	public String toString(){
		return FileSystemView.getFileSystemView().getSystemDisplayName(file);
	}
}


class FileTreeRenderer extends DefaultTreeCellRenderer {
	private FileSystemView fsv;
	public FileTreeRenderer(){
		fsv = FileSystemView.getFileSystemView();
	}
	public Component getTreeCellRendererComponent(JTree tree, 
													Object value,
													boolean sel, 
													boolean expanded, 
													boolean leaf, 
													int row,
													boolean hasFocus) {
		FileNode node = (FileNode) ((DefaultMutableTreeNode)value).getUserObject();
		Icon icon =fsv.getSystemIcon(((FileNode)node).getFile());;
		setLeafIcon(icon);
		setOpenIcon(icon);
		setClosedIcon(icon);
		
		return super.getTreeCellRendererComponent(tree, value, sel, expanded,
		leaf, row, hasFocus);
	}
}