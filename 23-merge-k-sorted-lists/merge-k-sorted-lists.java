import java.util.PriorityQueue;

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
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Priority Queue (Min-Heap) to store the nodes. 
        // We use a lambda expression to tell it to sort by node value in ascending order.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Step 1: Add the head of each linked list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        
        // Dummy node to easily build the resulting list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Step 2: Continuously extract the minimum node and add its successor
        while (!minHeap.isEmpty()) {
            // Get the smallest node currently available
            ListNode smallestNode = minHeap.poll();
            
            // Append it to our result list
            current.next = smallestNode;
            current = current.next; // Move the pointer forward
            
            // If the extracted node has a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}