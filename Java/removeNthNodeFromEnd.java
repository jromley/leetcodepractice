/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 1;
        ListNode headHolder = head;

        while(head.next != null) {
            head = head.next;
            size++;
        }
        
        head = headHolder;
        if(size == n){
            return head.next;
        }

        //traverse to the node before the one we want to skip
        for(int i = 0; i < size-n-1; i++){
            head = head.next;
        }

        //make the head skip the next node
        head.next = head.next.next;

        return headHolder;
    }
}