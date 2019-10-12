/**
 * @auther ikaruga
 * 下午8:27 - 2019/10/12
 */
public class IntegerToRoman {

    String[] s = new String[]{
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", //0 - 8
            "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", //9 - 17
            "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", //18 - 26
            "M", "MM", "MMM" // 27 - 29
    };


    public String intToRoman(int num) {
        StringBuilder b = new StringBuilder();
        if(num >= 1000){
            int t = num/1000;
            b.append(s[t + 26]);
            num = num - t * 1000;
        }
        if(num >= 100){
            int h = num / 100;
            b.append(s[h + 17]);
            num = num - h * 100;
        }
        if(num >= 10){
            int t = num / 10;
            b.append(s[t + 8]);
            num = num - t * 10;
        }
        if(num > 0){
            b.append(s[num - 1]);
        }
        return b.toString();
    }

}
