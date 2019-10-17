import java.util.ArrayList;
import java.util.List;

/**
 * @auther ikaruga
 * 下午3:31 - 2019/10/17
 */
public class LetterCombinationsOfAPhoneNumber {
    final static char[][] str = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        char[] digChars = digits.toCharArray();
        int[] idxs = new int[digChars.length];
        StringBuilder builder;
        while (idxs[0] < str[digChars[0] - 50].length) {
            boolean continueOut = false;
            for (int i = 0; i < idxs.length; i++) {
                if (idxs[i] >= str[digChars[i] - 50].length) {
                    idxs[i] = 0;
                    idxs[i - 1]++;
                    continueOut = true;
                    break;
                }
            }
            if (continueOut) {
                continue;
            }
            builder = new StringBuilder();
            for (int i = 0; i < idxs.length; i++) {
                builder.append(str[digChars[i] - 50][idxs[i]]);
            }
            idxs[digChars.length - 1]++;
            rst.add(builder.toString());
        }
        return rst;
    }

}
