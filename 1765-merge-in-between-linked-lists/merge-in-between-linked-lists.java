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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        for(int i =0; i<a-1; i++){
            curr = curr.next;
        }
        ListNode nodeBeforeA = curr;
        for(int i=0;i<b-a+2;i++){
            curr = curr.next;
        }
        ListNode nodeAfterB = curr;
        ListNode list2Tail = list2;

        while(list2Tail.next!=null){
            list2Tail = list2Tail.next;
        }
        nodeBeforeA.next = list2;
        list2Tail.next = nodeAfterB;
        return list1;
    }
}