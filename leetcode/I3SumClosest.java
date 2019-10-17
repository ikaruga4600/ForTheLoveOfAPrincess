import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther ikaruga
 * 上午10:11 - 2019/10/17
 */
public class I3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int rst = nums[0] + nums[1] + nums[len - 1];
        int min = Math.abs(rst - target);
        int pre = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            }
            pre = nums[i];
            int j = i + 1, k = len - 1;
            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(val - target) < min) {
                    min = Math.abs(val - target);
                    rst = val;
                }
            }
        }
        return rst;
    }

}
