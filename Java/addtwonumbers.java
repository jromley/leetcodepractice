/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return createNodeChain(l1, l2, new ListNode(), 0);
    }

    public ListNode createNodeChain(ListNode l1, ListNode l2, ListNode myChain, int carry){

        if(l1 == null && l2 == null){
            if(carry == 1){
                return myChain.next = new ListNode(1);
            } else {
                return null;
            }            
        } else if(l1 == null && l2 != null){
            myChain.val = (l2.val + carry) % 10;
            if(l2.val + carry >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            myChain.next = createNodeChain(l1, l2.next, new ListNode(), carry);
            return myChain;
        } else if(l1 != null && l2 == null){
            myChain.val = (l1.val + carry) % 10;
            if(l1.val + carry >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            myChain.next = createNodeChain(l1.next, l2, new ListNode(), carry);
            return myChain;
        }

        myChain.val = (l1.val + l2.val + carry) % 10;
        if(l1.val + l2.val + carry >= 10){
            carry = 1;
        } else {
            carry = 0;
        }
        
        myChain.next = createNodeChain(l1.next, l2.next, new ListNode(), carry);
        return myChain;
    }

}
