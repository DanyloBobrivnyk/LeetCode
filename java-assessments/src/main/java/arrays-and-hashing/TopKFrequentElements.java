import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var keys = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keys.get(i).getKey();
        }
        return res;
    }
}
