import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        if(arr.size() < 3) {
            return 0l;
        }
        HashMap<Long, Long> leftMap = new HashMap<>();
        HashMap<Long, Long> rightMap = new HashMap<>();
        Long result = 0L;
        for(int i = 0; i < arr.size(); i++) {
            rightMap.put(arr.get(i), rightMap.getOrDefault(arr.get(i), 0L) + 1);
        }
        for(int i = 0; i < arr.size(); i++) {
            rightMap.put(arr.get(i), rightMap.getOrDefault(arr.get(i), 0L) -1);
            if(arr.get(i) % r == 0) {
                result += leftMap.getOrDefault(arr.get(i)/r, 0L) * rightMap.getOrDefault(arr.get(i)*r, 0L);
            }
            leftMap.put(arr.get(i), leftMap.getOrDefault(arr.get(i), 0L) + 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\Projects\\java\\algo\\CountTriplets1.txt"))));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
