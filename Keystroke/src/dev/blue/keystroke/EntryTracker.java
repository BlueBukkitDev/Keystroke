package dev.blue.keystroke;

import java.util.ArrayList;
import java.util.List;

public class EntryTracker {
	private List<KeyTime> entries;
	
	/**
	 * Stores KeyTime records for comparison and evaluation to determine the differences in elapsed time between each keystroke, 
	 * deriving a pattern to be used as a second form of security/authorization, using biological tendencies and patterns in a 
	 * person's unique typing style. 
	 */
	public EntryTracker() {
		entries = new ArrayList<KeyTime>();
	}
	
	/**
	 * Stores a KeyTime record to be evaluated. 
	 * @param entry - the KeyTime record to store. 
	 */
	public void addEntry(KeyTime entry) {
		entries.add(entry);
	}
	
	/**
	 * This is an imperfect function, since it assumes each entry to be correctly typed. Will add a typo check later. <br>
	 * Assuming everything was typed correctly, prints out a list of average times for each char entered, providing a standard. 
	 */
	public void evaluate() {
		List<Integer> avgs = new ArrayList<Integer>();
		for(int i = 0; i < entries.get(0).size(); i++) {
			double total = 0;
			for(KeyTime each:entries) {
				total += each.getTimeInMilliseconds(i);//Confirmed to be accurate
			}
			avgs.add((int)KeyTracker.ratDec(total/entries.size(), 1));
		}
		for(int i = 0; i < avgs.size(); i++) {
			System.out.println(entries.get(0).getChar(i)+":"+avgs.get(i)+"ms");
		}
	}
}
