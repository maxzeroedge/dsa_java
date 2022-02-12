import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class RearrangeStringNoAdjacentCharacters {

	static class Pair<X,Y> {
		public X first;
		public Y second;

		public Pair(X x, Y y) {this.first = x; this.second = y;}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String testString = sc.nextLine();
		System.out.println(rearrangeString(testString));
	}

	public static String rearrangeString(String input) {
		PriorityQueue<Pair<Character, Integer>> frequencyQueue = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
			@Override public int compare(Pair<Character, Integer> c1, Pair<Character, Integer> c2) {
				if(c1.second > c2.second) { return -1;}
				else if (c1.second < c2.second) {return 1;}
				return c1.first.compareTo(c2.first);
			}
			@Override public boolean equals(Object obj) {
				return false;
			} 
		});
		/*Map<Character, Integer> charMap = new HashMap<>();
		for(char c: input.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}
		for(Map.Entry<Character, Integer> c: charMap.entrySet()) {
			frequencyQueue.add(new Pair(c.getKey(), c.getValue()));
		}*/
		int[] charCounts = new int[26];
		for(char c: input.toCharArray()) {
			charCounts[c - 'a']++;	
		}
		for(int i = 0; i < charCounts.length; i++) {
			if(charCounts[i] > 0) {frequencyQueue.add(new Pair(Character.toChars(i+'a')[0], charCounts[i]));}
		}
		String output = "";
		Pair<Character, Integer> firstPair = null, secondPair = null;
		while(!frequencyQueue.isEmpty()) {
			if(firstPair == null || firstPair.second == 0) {
				firstPair = frequencyQueue.remove();
				if(frequencyQueue.isEmpty()) {break;}
			}
			if(secondPair == null || secondPair.second == 0) {
				secondPair = frequencyQueue.remove();
			}
			while(firstPair != null && secondPair != null) {
				output += firstPair.first.toString() + secondPair.first.toString();
				firstPair.second -=1; secondPair.second -=1;
				if(firstPair.second == 0) {firstPair = null;}
				if(secondPair.second == 0) {secondPair = null;}
			}
		}
		if(firstPair != null && firstPair.second > 1) {
			return null;
		} else if (secondPair != null && secondPair.second > 1) {
			return null;
		}
		if(firstPair != null) {output += firstPair.first;}
		if(secondPair != null) {output += secondPair.first;}
		return output;
	}
}
