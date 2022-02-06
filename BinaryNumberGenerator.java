import java.util.*;

public class BinaryNumberGenerator {

    public static void updateNumberList(List<String> binaryList, int lastLength, int n) {
        if(lastLength == -1) {
            if(binaryList.isEmpty()) {
                binaryList.add("0");
                binaryList.add("1");
            } else {
                binaryList.add("10");
                binaryList.add("11");
                lastLength = 2;
            }
        } else {
            int startIndx = lastLength;
            lastLength = binaryList.size();
            for(int i = startIndx; i < lastLength; i++) {
                if(binaryList.size() >= n) {
                    break;
                }
                binaryList.add(
                    "10" + binaryList.get(i).substring(1)
                );
            }
            for(int i = startIndx; i < lastLength; i++) {
                if(binaryList.size() >= n) {
                    break;
                }
                binaryList.add(
                    "11" + binaryList.get(i).substring(1)
                );
            }
        }
        if(binaryList.size() < n) {
            updateNumberList(binaryList, lastLength, n);
        }
    }

    public static void main(String[] args) {
        List<String> binaryNumberList = new ArrayList<>();
        updateNumberList(binaryNumberList, -1, 20);
        binaryNumberList.forEach((binary) -> System.out.println(binary));
    }
}