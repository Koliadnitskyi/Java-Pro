package com.koliadnitskyi;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTasksTest {

    private final SolutionTasks tmp = new SolutionTasks();

    @Test
    public void maxProfitTest() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual = tmp.maxProfit(prices);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest() {
        ListNode starting = new ListNode(1) {
            {
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        ListNode expected = new ListNode(5) {
            {
                add(4);
                add(3);
                add(2);
                add(1);
            }
        };
        ListNode actual = tmp.reverse(starting);
        Assert.assertEquals(expected, actual);
    }
}
