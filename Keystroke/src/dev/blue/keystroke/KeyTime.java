package dev.blue.keystroke;

import java.util.ArrayList;
import java.util.List;

public class KeyTime {
	
	private List<Character> chars;
	private List<Long> times;
	
	/**
	 * Used to track character inputs and associated times elapsed. 
	 */
	public KeyTime() {
		chars = new ArrayList<Character>();
		times = new ArrayList<Long>();
	}
	
	/**
	 * Inserts a character and a time value into this KeyTime record. <br>
	 * Ideally, this is set up to insert only after the next key has been pressed, 
	 * timing the nanoseconds elapsed between key presses.
	 * @param c - the character represented by the key press.
	 * @param time - the long value in nanoseconds between this key press and the next.
	 */
	public void put(char c, long time) {
		chars.add(c);
		times.add(time);
	}
	
	/**
	 * Gets the character that was input at the specified index.
	 * @param index - the nth input.
	 * @return - the character at the specified index.
	 */
	public char getChar(int index) {
		return chars.get(index);
	}
	
	/**
	 * Gets the time elapsed associated with the character at this index.
	 * @param index - the nth input.
	 * @return - the elapsed time associated with the char at this index.
	 */
	public long getTime(int index) {
		return times.get(index);
	}
	
	/**
	 * Sets the time at an existing index. 
	 * @param index - the index of the record to change.
	 * @param time - the new time value to insert at the specified index.
	 * @throws IndexOutOfBoundsException if the index provided is greater than the size of the KeyTime record. 
	 */
	public void setTime(int index, long time) throws IndexOutOfBoundsException {
		times.set(index, time);
	}
	
	/**
	 * @return the size of the key & time record.
	 */
	public int size() {
		return chars.size();
	}
	
	/**
	 * Gets the <b>long</b> nanosecond value at the specified index and converts it to a double second value. 
	 * @param index - the index of the desired record.
	 * @return - the time in seconds at the specified index.
	 */
	public double getTimeInSeconds(int index) {
		return times.get(index)/1000000000.0;
	}
	/**
	 * Gets the <b>long</b> nanosecond value at the specified index and converts it to a double millisecond value. 
	 * @param index - the index of the desired record.
	 * @return - the time in milliseconds at the specified index.
	 */
	public double getTimeInMilliseconds(int index) {
		return times.get(index)/1000000.0;
	}
}
