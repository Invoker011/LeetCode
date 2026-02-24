package Swap_Nodes;

public class Solution {
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next!=null){

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution solution = new Solution();
        ListNode result = solution.swapPairs(node);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
        
    }
}
