/**
 * Created by jetta on 2017/8/1.
 */
public class ForEachTest {
    public static void main(String[] args) {
        int[] arrayList = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arrayList[i] = i;
        }
        int sum = 0;

        long startTime = System.currentTimeMillis();   //获取开始时间
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < arrayList.length; j++) {
                sum += arrayList[j];
            }
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("sum = "+sum+", fori程序运行时间： " + (endTime - startTime) + "ms");

        sum = 0;
        startTime = System.currentTimeMillis();   //获取开始时间
        for (int i = 0; i < 1000; i++) {
            for (Integer j : arrayList) {
                sum += j;
            }
        }
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("sum = "+sum+", foreach程序运行时间： " + (endTime - startTime) + "ms");

    }
}
