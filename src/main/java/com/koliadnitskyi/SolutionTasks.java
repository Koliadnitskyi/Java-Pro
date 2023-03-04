package com.koliadnitskyi;

public class SolutionTasks {
    public int maxProfit(int[] prices) {
        int tmp = 0;
        for (int u = 0; u < prices.length; u++) {
            for (int r = u + 1; r < prices.length; r++) {
                if (prices[r] > prices[u]) {
                    if (tmp < prices[r] - prices[u]) {
                        tmp = prices[r] - prices[u];
                    }
                }
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
