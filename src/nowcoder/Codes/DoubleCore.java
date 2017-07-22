package nowcoder.Codes;

import java.util.Scanner;

/**
 * Created by lijingwei on 22/07/2017.
 * AK!
 */
public class DoubleCore {

    public static int solve(int[] arr) {
        int len = 0;
        int[] propArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            propArr[i] = arr[i] / 1024;
            len += propArr[i];
        }

        boolean[] reach = new boolean[len + 1];
        reach[0] = true;
        for (int i = 0; i < propArr.length; i++) {
            for (int j = len / 2 - propArr[i]; j >= 0; j--) {
                if (reach[j]) {
                    reach[j + propArr[i]] = true;
                }
            }
        }
        int ans = len / 2;
        while (ans > 0 && !reach[ans]) {
            ans--;
        }
        return 1024 * (len - ans);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(solve(arr));
    }

}
