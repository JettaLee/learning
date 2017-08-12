package nowcoder.Codes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lijingwei on 2017/8/13.
 */
public class CrazyArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i]=1;
        }
        TemBean bean = new TemBean(0, list);
        backtrack(bean,0,  n, k);
        System.out.println(bean.sum);
        System.out.println();

    }

    private static void backtrack(TemBean bean, int start, int n, int k){
        if(bean.list[start]>k||start>=bean.list.length)return;
        if(check(bean.list,start)){
            bean.sum++;
            System.out.println(Arrays.toString(bean.list));
            for (int i = start; i < n; i++) {
                bean.list[i]++;
                backtrack(bean,i,n,k);
                bean.list[i]--;
            }
        }else{
            //最关键的点！！当出现类似2 1 1的情况时，继续遍历3 1 1及往后和2 2 1及往后，而2 1 2这种及以后的情况就直接忽略
            for (int i = start; i <=start+1; i++) {
                bean.list[i]++;
                backtrack(bean,i,n,k);
                bean.list[i]--;
            }
        }

    }

    //满足条件
    private static boolean check(int[] list, int i){
        boolean a = false,b = false;
        if(i>0){
            a = ((list[i-1]>list[i])&&(list[i-1]%list[i])==0);
        }
        if(i<list.length-1){
            b = ((list[i]>list[i+1])&&(list[i]%list[i+1])==0);
        }
        return !(a||b);

    }
}

class TemBean{

    public TemBean(int sum, int[] list) {
        this.sum = sum;
        this.list = list;
    }

    int sum;

    int[] list;

}
