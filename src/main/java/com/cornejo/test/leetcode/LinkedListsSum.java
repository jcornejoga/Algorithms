package com.cornejo.test.leetcode;

import java.util.List;

public class LinkedListsSum {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentNodeList1 = l1;
    ListNode currentNodeList2 = l2;
    ListNode result = new ListNode();
    ListNode currentInResult = result;
    boolean carry = false;
    while (currentNodeList1 != null || currentNodeList2 != null) {
      int sumVal = 0;
      int val1 = 0;
      int val2 = 0;
      if (currentNodeList1 != null) {
        val1 = currentNodeList1.val;
        currentNodeList1 = currentNodeList1.next;
      }
      if (currentNodeList2 != null) {
        val2 = currentNodeList2.val;
        currentNodeList2 = currentNodeList2.next;
      }
      sumVal = val1 + val2;
      if (carry) {
        sumVal++;
      }
      if (sumVal > 9) {
        sumVal = sumVal - 10;
        carry = true;
      } else {
        carry = false;
      }
      currentInResult.val = sumVal;
      if (currentNodeList1 != null || currentNodeList2 != null) {
        currentInResult.next = new ListNode();
        currentInResult = currentInResult.next;
      }
    }
    if (carry) {
      currentInResult.next = new ListNode();
      currentInResult.next.val = 1;
    }
    return result;
  }

  public static void main(String[] args) {
    //ListNode l1 = createNumber(342);
    //ListNode l2 = createNumber(465);
    ListNode l1 = createNumber(9999999);
    ListNode l2 = createNumber(9999);

    printNumber(l1);
    printNumber(l2);

    ListNode r = addTwoNumbers(l1, l2);
    printNumber(r);
  }

  public static ListNode createNumber(int number) {
    String numberString = String.valueOf(number);
    ListNode result = new ListNode();
    ListNode currentInResult = result;
    for (int i = numberString.length() - 1; i >= 0; i--) {
      currentInResult.val = Integer.parseInt(String.valueOf(numberString.charAt(i)));
      if (i > 0) {
        currentInResult.next = new ListNode();
        currentInResult = currentInResult.next;
      }
    }
    return result;
  }

  public static void printNumber(ListNode listNode) {
    ListNode current = listNode;
    System.out.println();
    while(current != null) {
      System.out.print(current.val);
      current = current.next;
    }
  }
}
