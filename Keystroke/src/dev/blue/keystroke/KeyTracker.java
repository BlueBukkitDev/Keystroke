package dev.blue.keystroke;

import java.awt.event.KeyEvent;

public class KeyTracker {
	/**
	 * Takes in a char and a float, where char = the key typed, and long = time since last keystroke
	 */
	private KeyTime keysPrimary;
	private KeyTime keysSecondary;
	private long lastTime;
	private char lastKey;
	private boolean trackingFirst;
	private boolean begun;
	
	public KeyTracker() {
		keysPrimary = new KeyTime();
		trackingFirst = true;
		begun = false;
	}
	
	public void addKeystroke(char value) {
		long timeSinceLast = 0;
		if(value == KeyEvent.VK_ENTER) {
			timeSinceLast = System.nanoTime()-lastTime;
			keysPrimary.put(value, timeSinceLast);
			trackingFirst = !trackingFirst;
			System.out.println("Tracking first: "+trackingFirst);
			System.out.println("Timing avg: "+averageValues(keysPrimary)+" seconds");
			begun = false;
			return;
		}
		if(trackingFirst) {
			if(begun = false) {
				lastKey = value;
				lastTime = System.nanoTime();
				System.out.println("Size is 0; this was your first keystroke");
				begun = true;
				return;
			}
			timeSinceLast = System.nanoTime()-lastTime;
			System.out.println("Entry: "+lastKey+" @ "+(timeSinceLast/1000000000.0)+" seconds");
			keysPrimary.put(lastKey, timeSinceLast);
			lastKey = value;
		}else {
			if(keysSecondary.size() == 0) {
				lastTime = System.nanoTime();
			}
			timeSinceLast = System.nanoTime()-lastTime;
			keysSecondary.put(value, timeSinceLast);
		}
	}
	
	private double averageValues(KeyTime map) {
		double total = 0.0;
		for(int i = 0; i < map.size(); i++) {
			total += map.getTimeInSeconds(i);
		}
		return total/map.size();
	}
}
