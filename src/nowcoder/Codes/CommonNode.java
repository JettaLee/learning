package nowcoder.Codes;

/**
 * Created by jetta on 2017/7/24.
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class CommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode tmp = pHead1;
        while (tmp != null) {
            tmp = tmp.next;
            len1++;
        }
        tmp = pHead2;
        while (tmp != null) {
            tmp = tmp.next;
            len2++;
        }
        if (len1 > len2) {
            while (len1 > len2) {
                pHead1 = pHead1.next;
                len1--;
            }
        } else {
            while (len1 < len2) {
                pHead2 = pHead2.next;
                len2--;
            }
        }
        while (pHead1 != null && pHead1.val != pHead2.val) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }


}
