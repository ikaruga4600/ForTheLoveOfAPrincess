/**
 * @auther ikaruga
 * 下午8:57 - 2019/10/12
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder b = new StringBuilder();
        int i = 0;
        while (true) {
            char c = '.';
            for (String s : strs) {
                if (i == s.length()) {
                    return b.toString();
                }
                if (c != '.' && c != s.charAt(i)) {
                    return b.toString();
                }
                c = s.charAt(i);
            }
            b.append(c);
            i++;
        }
    }
}
