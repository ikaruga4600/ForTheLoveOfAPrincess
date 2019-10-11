/**
 * @auther ikaruga
 * 下午8:46 - 2019/10/11
 */
public class ReverseInteger {

    public int reverse(int x) {
        int y = 0;
        int z = Math.abs(x);
        while (z != 0) {
            int k = y * 10;
            if(k / 10 != y){
                return 0;
            }
            int p = z / 10;
            y = k + z - p * 10;
            z = p;
        }

        if (x < 0) {
            return -y;
        }
        return y;
    }

}
