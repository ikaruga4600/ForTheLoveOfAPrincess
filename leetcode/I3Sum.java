import java.util.*;

/**
 * @auther ikaruga
 * 下午9:04 - 2019/10/12
 */
public class I3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums.length < 3) {
            return rst;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int pre = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            }
            pre = nums[i];
            int j = i + 1, k = len - 1;
            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val < 0) {
                    j++;
                } else if (val > 0) {
                    k--;
                } else {
                    List<Integer> l = new ArrayList<>(3);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    rst.add(l);
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(
                new I3Sum().threeSum(new int[]{-1, 0, 1, 0})
        );
    }

}
