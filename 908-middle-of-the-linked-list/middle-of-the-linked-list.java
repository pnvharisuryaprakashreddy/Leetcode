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
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int x = 1;
        while(cur.next!=null)
        {
            x++;
            cur=cur.next;
        }
        x=x/2;
        cur=head;
        while(x-->0)
        {
            cur=cur.next;
        }
        return cur;
    }
}