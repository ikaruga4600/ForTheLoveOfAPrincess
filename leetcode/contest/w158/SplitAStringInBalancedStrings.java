package contest.w158;

/**
 * @auther ikaruga
 * 上午10:37 - 2019/10/13
 */
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int result = 0;
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                l++;
            }
            if (c == 'R') {
                r++;
            }
            if (l == r) {
                result++;
            }
        }
        return result;
    }
}
