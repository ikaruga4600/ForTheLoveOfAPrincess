/**
 * @auther ikaruga
 * 下午5:50 - 2019/10/11
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }
        char[] charArr = s.toCharArray();
        int[] dp = new int[length];
        int[] dp2 = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            if (i < length - 1) {
                if (charArr[i] == charArr[i + 1]) {
                    dp2[i] = 1;
                }
            }
        }
        int max = 1;
        int width = 1;
        while (true) {
            boolean nextLoop = false;
            for (int i = width; i < length - width; i++) {
                if (dp[i] == width && charArr[i - width] == charArr[i + width]) {
                    nextLoop = true;
                    dp[i]++;
                }

                if (dp2[i] == width && i < length - width - 1 && charArr[i - width] == charArr[i + width + 1]) {
                    nextLoop = true;
                    dp2[i]++;
                }
            }
            if (!nextLoop) {
                int oddIdx = findIdx(dp, width);
                int evenIdx = findIdx(dp2, width);
                if (evenIdx != -1) {
                    return s.substring(evenIdx - width + 1, evenIdx + width + 1);
                } else {
                    return s.substring(oddIdx - width + 1, oddIdx + width);
                }
            }
            width++;
        }
    }

    private int findIdx(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestPalindromicSubstring().longestPalindrome("aaaa")
        );
    }
}
