/**
 * @auther ikaruga
 * 下午8:49 - 2019/10/12
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int pre = 0;
        int cur = 0;
        int i = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'M':
                    cur = 1000;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'I':
                    cur = 1;
                    break;
            }
            if (pre < cur) {
                i -= pre * 2;
            }
            i += cur;
            pre = cur;
        }
        return i;
    }

}
