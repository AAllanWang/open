package com.wangwl.myfileexplorer;
import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class WaitDialog extends JDialog {
	private static final long serialVersionUID = -2017901707408101146L;

	private Container parent;

	private String title;
	
	private String progressMessage;

	private static String cancelString = "Cancel";
	
	private JButton cancel;

	private WaitDialogListener listener = null;
	private JProgressBar bar;
	private static Object staticLock = new Object(); 

	/**
	 * Default constructor
	 * 
	 * @param title
	 *            the message to be displayed in the window's titlebar
	 * 
	 */
	public WaitDialog(JFrame parent, WaitDialogListener listener, String title) {
		super(parent, title);
		this.parent = parent;
		this.listener = listener;
		this.title = title;
		/*
		 * Set the dialog to be modal
		 */
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setResizable(false);
		initComponents();
	}

	public WaitDialog(JDialog parent, WaitDialogListener listener, String title) {
		super(parent, title);
		this.parent = parent;
		this.listener = listener;
		this.title = title;
		/*
		 * Set the dialog to be modal
		 */
		setModalityType(ModalityType.DOCUMENT_MODAL);
		initComponents();
	}
	
	public WaitDialog(JFrame parent, WaitDialogListener listener, String title,String progressMessage) {
		super(parent, title);
		this.parent = parent;
		this.listener = listener;
		this.title = title;
		this.progressMessage = progressMessage;
		/*
		 * Set the dialog to be modal
		 */
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setResizable(false);
		initComponents();
	}

	public WaitDialog(String title) {
		setTitle(title);
		this.title = title;
		/*
		 * Set the dialog to be modal
		 */
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setResizable(false);
		initComponents();
	}

	public void setWaitListener(WaitDialogListener listener) {
		this.listener = listener;
		if (listener != null)
			cancel.setEnabled(true);
	}
	public void setProgressMessage(String strMsg){
		bar.setString(strMsg);
	}
	private void initComponents() {
		cancel = new JButton(cancelString);
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		bar = new JProgressBar();
		bar.setPreferredSize(new Dimension(300, 30));
		bar.setIndeterminate(true);
		bar.setStringPainted(true);
		
		progressMessage = (progressMessage == null)? title : progressMessage;
		bar.setString(progressMessage);

		if (listener == null)
			cancel.setEnabled(false);

		panel.add(bar, BorderLayout.NORTH);

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(Box.createHorizontalGlue());
		if (listener != null) {
			buttons.add(cancel);
		}
		buttons.add(Box.createHorizontalGlue());
		panel.add(buttons, BorderLayout.SOUTH);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.cancel();
				dispose();
			}
		});

		pack();
		setLocationRelativeTo(parent);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private static WaitDialog dialog = null;

	/**
	 * launch a wait dialog with the given title and the given listener to the cancel event
	 * @param title	the dialog title
	 * @param listener	the listener handling the cancel button press
	 */
	public synchronized static void launchWaitDialog(final String title, final WaitDialogListener listener) {
		if (dialog != null) { // probably some kind of error
			return;
		}
		/*
		 * Execute the open of the dialog in a thread as the dialog is modal
		 */
		dialog = new WaitDialog(title);
		dialog.setWaitListener(listener);
		class RunWaitDiaolg extends SwingWorker<String, Object> {
	        public String doInBackground() {
	    		dialog.setVisible(true);
	        	return "";
	        } 
	    }
		new RunWaitDiaolg().execute();
		for (int i = 0 ; i < 600 ;i++){
			if (dialog.isVisible()) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	/**
	 * launch a wait dialog with the given title and the given listener to the cancel event
	 * @param title	the dialog title
	 * @param listener	the listener handling the cancel button press
	 */
	public synchronized static void launchWaitDialog(final String title, final WaitDialogListener listener, final String progressMessage,boolean cancelButton) {
		if (dialog != null) { // probably some kind of error
			return;
		}
		/*
		 * Execute the open of the dialog in a thread as the dialog is modal
		 */
		if (cancelButton){
			cancelString = progressMessage; 
		}
		
		if (!cancelButton && progressMessage!=null){
			dialog = new WaitDialog(title);
			dialog.setWaitListener(listener);
			dialog.setProgressMessage(progressMessage);
		}
		else{
			dialog = new WaitDialog(title);
		}
		(new Thread() {
			public void run() {
				dialog.setVisible(true);
			}
		}).start();
		while (!dialog.isVisible()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	

	/**
	 * launch a wait dialog with the given title , msg and listener
	 * @param title	the title of the wait dialog
	 * @param listener	the listener for the button press action
	 * @param cancelButtonText	the text on the cancel button
	 */
	public synchronized static void launchWaitDialog(final String title, final WaitDialogListener listener, String cancelButtonText) {
		cancelString = cancelButtonText;
		launchWaitDialog(title, listener);
	}
	
	public static void endWaitDialog() {
		synchronized (staticLock) {
			if (dialog == null) {
				return;
			}
			dialog.dispose();
			dialog = null;
		}
	}
/*
	public static void main(String[] args) {
		launchWaitDialog("Just wait a monent", null);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endWaitDialog();
	}
*/
}
