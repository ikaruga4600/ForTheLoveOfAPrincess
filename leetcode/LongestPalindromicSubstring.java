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
        int oddIdx = 0, evenIdx = -1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            if (i < length - 1) {
                if (charArr[i] == charArr[i + 1]) {
                    dp2[i] = 1;
                    evenIdx = i;
                }
            }
        }
        int width = 1;
        while (true) {
            boolean nextLoop = false;
            int currOddIdx = -1, currEvenIdx = -1;
            for (int i = width; i < length - width; i++) {
                if (dp[i] == width && charArr[i - width] == charArr[i + width]) {
                    nextLoop = true;
                    dp[i]++;
                    currOddIdx = i;
                }

                if (dp2[i] == width && i < length - width - 1 && charArr[i - width] == charArr[i + width + 1]) {
                    nextLoop = true;
                    dp2[i]++;
                    currEvenIdx = i;
                }
            }
            if (!nextLoop) {
                if (evenIdx != -1) {
                    return s.substring(evenIdx - width + 1, evenIdx + width + 1);
                } else {
                    return s.substring(oddIdx - width + 1, oddIdx + width);
                }
            }else{
                evenIdx = currEvenIdx;
                oddIdx = currOddIdx;
            }
            width++;
        }
    }


}
