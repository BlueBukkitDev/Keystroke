package dev.blue.keystroke;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KeyTracker tracker;

	public Window() {
		Dimension d = new Dimension(700, 500);
		tracker = new KeyTracker();
		this.setTitle("Keystroke Timer");
		this.setSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setLocationRelativeTo(null);
		this.addKeyListener(new KeyManager(tracker));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
}
