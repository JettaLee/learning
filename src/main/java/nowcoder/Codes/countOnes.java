package nowcoder.Codes;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jetta on 2017/8/1.
 */
public class countOnes {

    public static int count(int n) {
        int z = 0, cnt = 0;
        int y = n % 10;
        int x = n / 10;
        int times = 1;
        while (z != n) {
            cnt += x * times + (y == 0 ? 0 : (z + 1));
            z += y * times;
            y = x % 10;
            x /= 10;
            times *= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(count(n));
        for(int n = (int)Math.pow(10,10);n>0;n--){
            if(count(n)==n){
                System.out.println(n);
                break;
            }
        }
    }
}
