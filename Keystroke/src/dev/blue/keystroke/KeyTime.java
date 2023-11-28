package dev.blue.keystroke;

import java.util.ArrayList;
import java.util.List;

public class KeyTime {
	
	private List<Character> chars;
	private List<Long> times;
	
	public KeyTime() {
		chars = new ArrayList<Character>();
		times = new ArrayList<Long>();
	}
	
	public void put(char c, long time) {
		chars.add(c);
		times.add(time);
	}
	
	public char getKey(int index) {
		return chars.get(index);
	}
	
	public long getTime(int index) {
		return times.get(index);
	}
	
	public void setTime(int index, long time) {
		times.set(index, time);
	}
	
	public int size() {
		return chars.size();
	}
	
	public double getTimeInSeconds(int index) {
		return times.get(index)/1000000000.0;
	}
}
