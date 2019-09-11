package leetcode.linkedlist;

/**
 * @author ikaruga
 * 2019/9/11-10:31 AM
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addVal = 0;
        ListNode root = null;
        ListNode preNode = null;
        while (l1 != null || l2 != null || addVal > 0) {
            int l1Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            int l2Val = 0;
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int val = l1Val + l2Val + addVal;
            if (val > 9) {
                val = val - 10;
                addVal = 1;
            } else {
                addVal = 0;
            }
            ListNode node = new ListNode(val);
            if(preNode != null){
                preNode.next = node;
                preNode = node;
            }else{
                preNode = node;
            }
            if(root == null){
                root = preNode;
            }
        }
        if(root == null){
            root = new ListNode(0);
        }
        return root;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
