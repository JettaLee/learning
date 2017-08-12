package Leetcode.Codes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lijingwei on 2017/8/12.
 */
public class SmallestRange {
    public int[] smallestRange(int[][] nums) {
        //new一个PQ，根据val值排序（从小到大）
        PriorityQueue<Element> pq = new PriorityQueue<Element>(3500, new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });

        //记录两个值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        //遍历nums，把所有数组的首个元素入队，找到其中的max
        for (int i = 0; i < nums.length; i++) {
            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);
            max = Math.max(max, nums[i][0]);
        }

        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.length) {

            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums[curr.row].length) {
                curr.idx = curr.idx + 1;
                curr.val = nums[curr.row][curr.idx];
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }

    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }

    public static void main(String[] args) {
        SmallestRange smallestRange = new SmallestRange();
        PriorityQueue<Element> pq = new PriorityQueue<Element>(3500, new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        pq.add(smallestRange.new Element(1,2,3));
        pq.add(smallestRange.new Element(1,2,4));
        pq.add(smallestRange.new Element(1,2,5));
        pq.add(smallestRange.new Element(1,2,0));
        System.out.println(pq.poll().val);

    }
}
