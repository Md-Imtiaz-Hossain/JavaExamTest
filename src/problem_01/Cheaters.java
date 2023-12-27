package problem_01;

import java.util.Arrays;
import java.util.TreeSet;

public class Cheaters {
    public static void main(String[] args) {
        int[] location1 = {1234567, 2345678, 3456789};
        int[] location2 = {2345678, 4567890, 5678901};
        System.out.println(Arrays.toString(removeDuplicates(location1, location2)));
    }
    public static int[] removeDuplicates(int[] location1, int[] location2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : location1) {
            set.add(num);
        }
        for (int num : location2) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set){
            result[i++] = num;
        }
        return result;
    }
}
