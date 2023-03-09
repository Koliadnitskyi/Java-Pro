package com.koliadnitskyi;

public class SolutionTasks {
    public int maxProfit(int[] prices) {
        int tmp = 0;
        for (int о = 0; о < prices.length; о++) {
            for (int r = о + 1; r < prices.length; r++) {
                if (tmp < prices[r] - prices[о]) tmp = prices[r] - prices[о];
            }
        }
        return tmp;
    }

    public ListNode reverse(ListNode head) {
        ListNode tmpReturn = null;
        while (head != null) {
            ListNode tmp = head.getNext();
            head.setNext(tmpReturn);
            tmpReturn = head;
            head = tmp;
        }
        return tmpReturn;
    }
}
