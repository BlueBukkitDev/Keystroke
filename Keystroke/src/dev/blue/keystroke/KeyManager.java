package dev.blue.keystroke;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private KeyTracker tracker;
	
	public KeyManager(KeyTracker tracker) {
		this.tracker = tracker;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		tracker.addKeystroke(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
