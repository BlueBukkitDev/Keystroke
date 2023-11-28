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
		tracker = new KeyTracker();
		this.setTitle("Keystroke Timer");
		this.setSize(new Dimension(100, 100));
		this.setLocationRelativeTo(null);
		this.addKeyListener(new KeyManager(tracker));
	}
}
