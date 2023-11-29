package dev.blue.keystroke;

import java.awt.event.KeyEvent;

public class KeyTracker {

	private KeyTime keys;
	private EntryTracker entryTracker;
	private long lastTime;
	private char lastKey;
	private boolean begun;
	private long timeSinceLast = 0;
	
	/**
	 * Tracks keyboard input characters and time until next keyboard input; after a completed input, sends that data to the 
	 * EntryTracker for evaluation. 
	 * 
	 * To use, simply instantiate in a KeyListener class and call addKeystroke inside keyTyped(). Example: <br>
	 * <pre>{@code
	 *  public class KeyManager implements KeyListener {
	 *      private KeyTracker tracker;
	 *
	 *      public KeyManager(KeyTracker tracker) {
	 *          this.tracker = tracker;
	 *      }
	 * 
	 *      @override
	 *      keyTyped(KeyEvent e){
	 *          addKeystroke(e.getKeyChar());
	 *      }
	 *  }
	 * }</pre>
	 */
	public KeyTracker() {
		keys = new KeyTime();
		entryTracker = new EntryTracker();
		begun = false;
	}
	
	/**
	 * Takes the input char and either completes an entry (if key char is VK_ENTER) or iterates an entry (any other key). 
	 * @param value
	 */
	public void addKeystroke(char value) {
		if(value == KeyEvent.VK_ENTER) {
			iterateEntry(value);
			handleCompletion();
			return;
		}
		if(!begun) {
			initiate(value);
			return;
		}
		iterateEntry(value);
		lastKey = value;
		lastTime = System.nanoTime();
	}
	
	/**
	 * Marks the first entry into the keyTime record, begins the key press timer. 
	 * @param value
	 */
	private void initiate(char value) {
		lastKey = value;
		lastTime = System.nanoTime();
		System.out.print(value);
		begun = true;
	}
	
	/**
	 * Updates the key press timer and inserts the last input and the time passed into the keyTime record. 
	 * @param value - the character being input.
	 */
	private void iterateEntry(char value) {
		timeSinceLast = System.nanoTime()-lastTime;
		System.out.print(value);
		keys.put(lastKey, timeSinceLast);
	}
	
	/**
	 * Logs the whole record to the entry tracker, prints results to the console, resets the system for the next input, and runs an evaluation. 
	 */
	private void handleCompletion() {
		entryTracker.addEntry(keys);
		System.out.println("Input tracked and stored.");
		System.out.println("Timing avg: "+ratDec(averageValues(keys), 4)+" seconds");
		System.out.println("Total time: "+ratDec(totalTime(keys), 4));
		keys = new KeyTime();
		begun = false;
		entryTracker.evaluate();
	}
	
	/**
	 * A utility function that may not have a use in the final product; useful for now for debugging and testing. 
	 * @param map - a KeyTime record. 
	 * @return the total time elapsed during input recording.
	 */
	private double totalTime(KeyTime entry) {
		double total = 0.0;
		for(int i = 0; i < entry.size(); i++) {
			total += entry.getTimeInSeconds(i);
		}
		return total;
	}
	
	/**
	 * A utility function that may not have a use in the final product; useful for now for debugging and testing. 
	 * @param map - a KeyTime record.
	 * @return the average value of all inputs.
	 */
	private double averageValues(KeyTime entry) {
		double total = 0.0;
		for(int i = 0; i < entry.size(); i++) {
			total += entry.getTimeInSeconds(i);
		}
		return total/entry.size();
	}
	
	/**
	 * A utility function to rationalize a decimal to the specified places. <br>Note that this will not round the 
	 * final digit, but instead will simply cut off the number at the specified point. For instance, the 
	 * number 45.049, when rationalized to 2 places, will return 45.04, not 45.05. 
	 * @param d - the double to be rationalized.
	 * @param places - the max number of digits to follow the decimal point.
	 * @return the rationalized double.
	 */
	public static double ratDec(double d, int places) {
		double div = Math.pow(10, places);
		return Math.floor(d*div)/div;
	}
}
