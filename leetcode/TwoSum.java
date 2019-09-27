import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author ikaruga
 * 2019/9/11-10:21 AM
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer firstIndex = map.get(target - num);
            if (map.containsKey(target - num)) {
                int[] result = new int[2];
                result[0] = firstIndex;
                result[1] = i;
                return result;
            }else{
                map.put(num, i);
            }
        }
        return null;
    }

}
