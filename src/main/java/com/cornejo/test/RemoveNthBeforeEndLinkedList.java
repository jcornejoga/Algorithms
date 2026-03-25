package com.cornejo.test;

public class RemoveNthBeforeEndLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            sb.append("{");
            while (current != null) {
                sb.append(current.val);
                sb.append(",");
                current = current.next;
            }
            sb.append("}");

            return sb.toString();
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode prev = null;
        int pos = 0;

        while (current != null) {
            if (pos == n) {
                prev = head;
            } else if (pos > n) {
                prev = prev.next;
            }
            pos++;
            current = current.next;
        }

        //System.out.println(pos);
        //System.out.println(prev.val);

        if (prev == null) {
            head = head.next;
            return head;
        }

        if (prev.next != null) {
            prev.next = prev.next.next;
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addElement(head, 2);
        addElement(head.next, 3);
        addElement(head.next.next, 4);
        addElement(head.next.next.next, 5);

        head = new ListNode(1);
        //addElement(head, 2);

        int n = 1;

        System.out.println(head.toString() + " n " + n);

        head = removeNthFromEnd(head, n);

        System.out.println(head.toString());

    }

    public static void addElement(ListNode e, int value) {
        e.next = new ListNode(value);
    }
}
