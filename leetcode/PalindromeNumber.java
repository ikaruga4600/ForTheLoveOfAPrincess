/**
 * @auther ikaruga
 * 下午10:10 - 2019/10/11
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int[] y = new int[20];
        int i = 0;
        while (x != 0) {
            int z = x / 10;
            y[i++] = x - z * 10;
            x = z;
        }

        for (int j = 0; j <= (i - 1) / 2; j++) {
            if(y[j] != y[i - 1 - j]){
                return false;
            }
        }
        return true;
    }

}
