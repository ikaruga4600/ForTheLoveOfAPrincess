/**
 * @auther ikaruga
 * 下午9:39 - 2019/10/11
 */
public class StringToInteger {

    int idx = 0;
    int len;
    char[] chars;
    int val = 0;
    boolean positive = true;
    boolean oor = false;

    public int myAtoi(String str) {
        len = str.length();
        if(len == 0){
            return 0;
        }
        chars = str.toCharArray();
        expectWhitSpace();
        if(oor){
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return positive ? val : -val;
    }

    boolean scan() {
        return ++idx < len;
    }

    private boolean expectWhitSpace() {
        if (chars[idx] == ' ') {
            return scan() && expectWhitSpace();
        }
        return expectSign();
    }

    private boolean expectSign() {
        if (chars[idx] == '-') {
            positive = false;
            return scan() && expectNumber();
        }
        if(chars[idx] == '+'){
            return scan() && expectNumber();
        }
        return expectNumber();
    }

    private boolean expectNumber() {
        char c = chars[idx];
        if (c >= '0' && c <= '9') {
            int x = val * 10 - 48 + c;
            if(x / 10 != val){
                oor = true;
                return false;
            }
            val = x;
            return scan() && expectNumber();
        }
        return false;
    }

}
