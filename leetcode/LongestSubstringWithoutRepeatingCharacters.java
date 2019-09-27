/**
 * @author ikaruga
 * 2019/9/11-11:12 AM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Integer[] charIndex = new Integer[256];
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndex[c] != null && charIndex[c] >= left) {
                maxLength = Math.max(maxLength, i - left);
                left = charIndex[c] + 1;
            }else{
                maxLength = Math.max(maxLength, i + 1 - left);
            }
            charIndex[c] = i;
        }
        return maxLength;
    }

}
