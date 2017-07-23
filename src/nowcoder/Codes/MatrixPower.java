package nowcoder.Codes;

import java.util.Scanner;

/**
 * Created by lijingwei on 23/07/2017.
 */
public class MatrixPower {

    private static int[][] multiply(int[][] a, int[][] b){
        int[][] ans = new int[a.length][b[0].length];
        for(int i = 0;i<a.length;i++){
            for (int j = 0; j < b[0].length ; j++) {
                for (int k = 0; k < b.length; k++) {
                    ans[i][j]+=a[i][k]*b[k][j];
                    //这句写的时候漏了
                    ans[i][j]%=100;
                }
            }
        }
        return ans;
    }

    private static int[][] matrixOfPower(int[][] mat, int n){
        int[][] ans = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            ans[i][i]=1;
        }
        while (n!=0){
            if((n&1)==1){
                ans = multiply(ans,mat);
            }
            n>>=1;
            mat = multiply(mat,mat);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] init = new int[n];
        for(int i=0;i<n;i++){
            init[i]=in.nextInt();
        }



        int[][] multiplier = new int[n][n];
        for (int i = 0; i < n ; i++) {
            multiplier[i][i] = 1;
            multiplier[i][(i+1)%n]=1;
        }

        multiplier = matrixOfPower(multiplier, k);

        int[] ans = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i]+=multiplier[i][j]*init[j];
                ans[i]%=100;
            }

            //sb.append(ans[i]+' '); 这里append的不是对应数字+' '，也就是不是数字转型为字符串相加，而是' '转型为int后相加
            sb.append(ans[i]+" ");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
}
