import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class GSOne {

    static String[] input1 = new String[] {"abc", "bac", "cat", "dog", "tac", "pest", "step"};
    static int[][] input2 = new int[][] {
        {0,0,0,1},
        {1,0,1,1},
        {1,1,1,0},
        {1,1,1,1}
    };
    
    public static void main(String[] args) {
        AnagramSets.generateAnagramSets(input1).stream().forEach((angramSet) -> {
            System.out.println(
                angramSet.stream().reduce((accum, angramItem) -> {
                    return accum + "," + angramItem;
                }).orElse("")
            );
        });
        System.out.println(MaximumStones.countMaximumStones(input2));
    }
}

class AnagramSets {

    public static String sortedString(String inputString) {
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static List<List<String>> generateAnagramSets(String[] inputStringList) {
        Map<String, Set<String>> stringMap = new HashMap<>();
        for(String stringItem: inputStringList) {
            // Sort characters in stringItem and push to map
            String keyName = AnagramSets.sortedString(stringItem);
            if(!stringMap.containsKey(keyName)) {
                stringMap.put(keyName, new HashSet<>());
            }
            stringMap.get(keyName).add(stringItem);
        }
        List<List<String>> returnableList = new ArrayList<>();
        stringMap.keySet().forEach((stringMapItem) -> {
            returnableList.add(new ArrayList<>(stringMap.get(stringMapItem)));
        });
        return returnableList;
    }
}

class MaximumStones {

    static int maximumStoneFromPosition(int[][] routeMap, int x, int y) {
        int count = routeMap[x][y];
        if(x < routeMap.length - 1) {
            if(y > 0) {
                count += Math.max(Math.max(MaximumStones.maximumStoneFromPosition(routeMap, x + 1, y - 1), 
                MaximumStones.maximumStoneFromPosition(routeMap, x, y - 1)), MaximumStones.maximumStoneFromPosition(routeMap, x + 1, y));
            } else {
                count += MaximumStones.maximumStoneFromPosition(routeMap, x + 1, y);
            }
        } else {
            if(y > 0) {
                count += MaximumStones.maximumStoneFromPosition(routeMap, x, y - 1);
            } else {
                return count; // Last element
            }
        }
        return count;
    }

    public static int countMaximumStones(int[][] routeMap) {
        return maximumStoneFromPosition(routeMap, 0, routeMap[0].length - 1);
    }
}