package com.jojo.training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * just for test!
 *
 */
public class AppMainTest {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            maxLength = Math.max(maxLength, i - start + 1);
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
                if (sum < 10)
                    return new ListNode(sum);
                return new ListNode(sum % 10, new ListNode(sum / 10));
            }
            boolean flag = false;
            if (l1.next != null) {
                l1.next.val += sum / 10;
                flag = true;
            }
            if (l2.next != null && !flag) {
                l2.next.val += sum / 10;
            }
            return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
        }
        return null;
    }

    public static void main(String[] args) {
        int lengthOfLongestSubstring = lengthOfLongestSubstring("dvdf");
        ;
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode addTwoNumbers = addTwoNumbers(l1, l2);

        System.out.println("Hello world! " + lengthOfLongestSubstring);
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
}