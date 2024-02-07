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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        boolean done = false;

        while(!done){

            done = true;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null){
                    pq.add(lists[i].val);  
                    lists[i]=lists[i].next;
                    done = false;
                }
            }
        }

        if(pq.isEmpty()){
            return null;
        }

        ListNode result = new ListNode(pq.poll());
        ListNode head = result;
        while (!pq.isEmpty()) {
            result.next = new ListNode(pq.poll());
            result = result.next;
        }

        return head;
        
    }
}