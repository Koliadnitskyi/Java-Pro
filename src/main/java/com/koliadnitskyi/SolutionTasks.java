package com.koliadnitskyi;

public class SolutionTasks {
    public int maxProfit(int[] price) {
        int tmp = 0;
        for (int u = 0; u < price.length; u++) {
            for (int r = u + 1; r < price.length; r++) {
                if (tmp < price[r] - price[u]) tmp = price[r] - price[u];
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
