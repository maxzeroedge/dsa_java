import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NumbersToBiggestNumber {

	static class IntArrayComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			if(a.length > b.length) {
				return 1;
			} else if (a.length < b.length) {return -1;}
			else {
				for(int i = a.length - 1; i >= 0; i--) {
					if(a[i] < b[i]) {return 1;}
					else if (a[i] > b[i]) {return -1;}
				}
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for(int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(longestNumber(numbers));
	}

	public static int[] getDigitsAsArray(int number) {
		int num_digits = 0;
		int temp = number;
		while(temp % 10 > 0) {
			temp = temp / 10;
			num_digits++;
		}
		int[] number_digits = new int[num_digits];
		for(int i = num_digits - 1; i>=0; i--) {
			number_digits[i] = number % 10;
			number = number / 10;
		}
		return number_digits;
	}

	public static String longestNumber(int[] numbers){
		List<List<int[]>> number_indexes = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			number_indexes.add(new ArrayList<>());
		}
		for(int i = 0; i < numbers.length; i++) {
			int current_number = numbers[i];
			int[] current_digits = getDigitsAsArray(current_number);
			int left_digit = current_digits[0];
			number_indexes.get(left_digit).add(current_digits);
			System.out.println(String.format("%d %d", left_digit, current_number));
		}
		String output = "";
		for(int i = 9; i >=0; i--) {
			if(!number_indexes.get(i).isEmpty()) {
				List<int[]> numbers_at_index = number_indexes.get(i);
				Collections.sort(numbers_at_index, new IntArrayComparator());
				for(int[] number : numbers_at_index) {
					for(int n: number) {
						output += Integer.valueOf(n);
					}
				}
			}
		}
		return output;
	}
}
