package com.jojo.training;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * just for test!
 *
 */
public class AppMainTest {

    public static final Logger log = Logger.getLogger(AppMainTest.class.getName());
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            maxLength = Math.max(maxLength, i - start);
            map.put(ch, i);
        }
        return maxLength;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            l1 = l1 == null ? new ListNode() : l1;
            l2 = l2 == null ? new ListNode() : l2;
            int sum = l1.val + l2.val;
            if (l1.next == null && l2.next == null) {
                return new ListNode(sum % 10, sum > 9 ? new ListNode(sum / 10) : null);
            }
            l1.next = l1.next == null ? new ListNode() : l1.next;
            l2.next = l2.next == null ? new ListNode() : l2.next;
            l1.next.val+=sum/10;
            return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
        }
        return null;
    }

    public static void main(String[] args) {
        int lengthOfLongestSubstring = lengthOfLongestSubstring("dvdf");
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode addTwoNumbers = addTwoNumbers(l1, l2);

        log.log(Level.INFO, "Hello world! {0}", String.valueOf(lengthOfLongestSubstring));
        log.log(Level.INFO, "Hello world! {0}", addTwoNumbers);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        ListNode node = this;
        while (node != null) {
            str.append(node.val).append(",");
            node = node.next;
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));
        str.append("]");
        return str.toString();
    }
}