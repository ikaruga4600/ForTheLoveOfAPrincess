/**
 * @auther ikaruga
 * 下午6:47 - 2019/10/11
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        char[] newC = new char[s.length()];
        int cnt = 0;
        int i = 2 * numRows;
        for (int j = 0; j < numRows; j++) {
            int k = j;
            int l = i - j * 2 - 2;
            while (k < s.length()) {
                newC[cnt++] = c[k];
                if (l > 0 && j != 0 && j != numRows - 1 && k + l < s.length()) {
                    newC[cnt++] = c[k + l];
                }
                k = k + i - 2;
            }
        }
        return new String(newC);
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("abcdef", 4));
    }

}
