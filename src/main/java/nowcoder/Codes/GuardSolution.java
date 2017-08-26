package nowcoder.Codes;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by lijingwei on 2017/8/26.
 */
public class GuardSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
    }

    /**
     * 拿到圆环中下一个元素的索引，因为这里是用数组来表示圆环的
     *
     * <a href="/profile/547241" data-card-uid="547241" class="js-nc-card" target="_blank" style="color: #25bb9b">@param size
     * @param i
     * @return
     */
    public static int nextIndexInCircle(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    /**
     * 单调栈中在栈顶相遇的相同元素之间构成的可观察岗哨对数
     *
     * </a><a href="/profile/547241" data-card-uid="547241" class="js-nc-card" target="_blank" style="color: #25bb9b">@param n
     * @return
     */
    public static long getInternalSum(int n) {
        return n == 1 ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        int value = arr[maxIndex];  // 先找到数组中的一个最大值（可能不止一个）
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value)); // 先把最大值压入单调栈栈底
        long res = 0L;
        int index = nextIndexInCircle(size, maxIndex);
        while (index != maxIndex) {
            value = arr[index];
            while (!stack.isEmpty() && value > stack.peek().value) {    // 来了一个更大的元素
                int times = stack.pop().times;      // 栈顶元素出栈，并拿到该栈顶元素的累计个数
                // 出栈的栈顶元素之间构成可观察岗哨对数C(times)2 = n*(n-1)/2，当times==1时，构成的可观察岗哨对数为0
                // 出栈的栈顶元素与它下面的元素以及使它出栈的元素所构成的可观察岗哨对数times * 2
                res += getInternalSum(times) + times * 2;
            }
            if (!stack.isEmpty() && value == stack.peek().value) {  // 累加栈顶相遇的相同元素个数
                stack.peek().times++;
            } else {    // stack.isEmpty() || value < stack.peek().value
                stack.push(new Pair(value));
            }
            index = nextIndexInCircle(size, index);
        }
        while (!stack.isEmpty()) {  // 所有的元素都已遍历了一遍，单调栈不空
            int times = stack.pop().times;
            res += getInternalSum(times);   // 相同元素之间构成的可观察岗哨对数
            if (!stack.isEmpty()) {
                res += times;   // 与它下面的元素所构成的可观察岗哨对数   [此处标记]
                if (stack.size() >= 2) {    // 它下面并不是栈底最大值
                    res += times;   // 与栈底最大值所构成的可观察岗哨对数
                } else {    // 它下面已是栈底最大值
                    res += stack.peek().times == 1 ? 0 : times; // 如果它下面的栈底最大值只有1个，显然它已经在有[标记]的那一行加过了
                }
            }
        }
        return res;
    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }
}
