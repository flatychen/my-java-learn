package flaty.leetcode.medium;

import org.apache.commons.lang3.RandomUtils;

/**
 * 加法运算，从低位到高位计算，考虑进位，不相等
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * 主要是锭表的操作
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    /**
     *
     * 简单代码写法
     *
     * 1. 链表中，给链表增加头节点是一个很重要的写法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode simpleCodeAdd(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode cur = sumList;
        int lastStep = 0;
        while (l1 != null || l2 != null || lastStep != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + lastStep;
            lastStep = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return sumList.next;
    }


    /**
     *
     * 我自个的写法，太长太长了，哈哈哈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode simpleAdd(ListNode l1, ListNode l2) {
        ListNode sumList = null;
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode currentSum = null;

        int lastStep = 0;
        while ((current1 != null && current2 != null)) {

            int sum = current1.val + current2.val + lastStep;

            int value = 0;

            if (sum < 10) {
                lastStep = 0;
                value = sum;
            } else {
                lastStep = 1;
                value = sum % 10;
            }

            ListNode node = new ListNode(value);

            if (currentSum == null) {
                currentSum = node;
                sumList = node;
            } else {
                currentSum.next = node;
                currentSum = currentSum.next;
            }
            current1 = current1.next;
            current2 = current2.next;
        }


        ListNode lastList = current1 != null ? current1 : current2 != null ? current2 : null;
        while (lastList != null) {
            int sum = lastList.val + lastStep;
            int value = 0;
            if (sum < 10) {
                lastStep = 0;
                value = sum;
            } else {
                lastStep = 1;
                value = sum % 10;
            }

            ListNode node = new ListNode(value);
            currentSum.next = node;
            currentSum = currentSum.next;
            lastList = lastList.next;
        }

        if (lastStep == 1) {
            ListNode node = new ListNode(lastStep);
            currentSum.next = node;
        }
        return sumList;
    }


    /**
     * 产生队列
     *
     * @param length
     * @return
     */
    public ListNode genList(int length) {
        ListNode head = null, cur = head;
        for (int i = 0; i < length; i++) {
            ListNode node = new ListNode(RandomUtils.nextInt(1, 3));
            if (cur == null) {
                cur = node;
                head = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.genList(5);

        addTwoNumbers.genList(5);
        ListNode l1 = addTwoNumbers.genList(3);
        ListNode l2 = addTwoNumbers.genList(3);
        ListNode sum = addTwoNumbers.simpleAdd(l1, l2);
        System.out.println(sum);


    }


}

