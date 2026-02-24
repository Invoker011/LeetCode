package merge_K_sorted_List;

import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKsortedList(ListNode[] lists){
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;;

            if(smallest.next != null){
                pq.offer(smallest.next);
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(3, new ListNode(6));
        ListNode[] lists = {l1, l2, l3};

        Solution solution = new Solution();
        ListNode mergedHead = solution.mergeKsortedList(lists);

        // Print the merged linked list
        ListNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
