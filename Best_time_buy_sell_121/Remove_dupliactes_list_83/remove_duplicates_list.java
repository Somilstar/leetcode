package Best_time_buy_sell_121.Remove_dupliactes_list_83;


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
    public ListNode deleteDuplicates(ListNode node) {
        if(node ==null){
            return node;
        }
        ListNode head = node;
        while(node.next!= null){
            if(node.val== node.next.val){
                node.next = node.next.next; 
            }
            else{
                node = node.next;
            }
        }
        return head;

    }
}