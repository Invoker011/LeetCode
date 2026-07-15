package Sum_OF_Two_Number_LinkedList;

public class Solution {
    public ListNode sumOfTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carryOver = 0;
        while(temp1 != null || temp2 != null){
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp1.val;

            int sum = val1 + val2 + carryOver;
            carryOver = sum/10;
            currentNode.next = new ListNode(sum % 10);

            if(temp1.next != null){
                temp1 = temp1.next;
            }
            if (temp2.next != null) {
                temp2 = temp2.next;
            }
            currentNode = currentNode.next;
        }
        if(carryOver > 0){
            currentNode.next = new ListNode(carryOver);
        }
        return dummyNode.next;
    }
    
}
