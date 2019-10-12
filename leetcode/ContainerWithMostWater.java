/**
 * @auther ikaruga
 * 下午7:43 - 2019/10/12
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;

        int leftEnd = len - 1;
        int rightStart = 0;
        if (len > 8) {
            int max1 = 0;
            int max2 = 0;
            for (int i = 0; i < len; i++) {
                if (height[i] >= max1) {
                    max2 = max1;
                    rightStart = leftEnd;
                    max1 = height[i];
                    leftEnd = i;
                } else if (height[i] >= max2) {
                    max2 = height[i];
                    rightStart = i;
                }
            }
            if (leftEnd > rightStart) {
                int tmp = leftEnd;
                leftEnd = rightStart;
                rightStart = tmp;
            }
        }

        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i <= leftEnd; i++) {
            if (height[i] <= maxI) {
                continue;
            }
            maxI = height[i];
            maxJ = 0;
            for (int j = len - 1; j >= rightStart && j > i; j--) {
                if (height[j] <= maxJ) {
                    continue;
                }
                maxJ = height[j];
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})
        );

    }
}
