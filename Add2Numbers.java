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
class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        boolean carry = false;
        int data = 0;
        while(l1 != null && l2 != null){
            data = l1.val + l2.val;
            if(carry){
                data += 1;
            }
            if(data > 9){
                head = insert(head, data%10);
                carry = true;
            }else{
                head = insert(head, data);
                carry = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            data = l1.val;
            if(carry){
                data += 1;
            }
            if(data > 9){
                head = insert(head, data%10);
                carry = true;
            }else{
                head = insert(head, data);
                carry = false;
            }
            l1 = l1.next;
        }
        while(l2 != null){
           data = l2.val;
           if(carry){
                data += 1;
            }
            if(data > 9){
                head = insert(head, data%10);
                carry = true;
            }else{
                head = insert(head, data);
                carry = false;
            }
            l2 = l2.next; 
        }
        if(carry){
            head = insert(head, 1);
        }
        return head;
    }
    
    public ListNode insert(ListNode head, int data){
        ListNode temp = new ListNode(data);
        if(head == null){
            head = temp;
        }else{
            ListNode ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return head;
    }
    
}