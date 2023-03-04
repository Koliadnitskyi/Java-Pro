package com.koliadnitskyi;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTasksTest {
    @Test
    public void maxProfitTest() {
        SolutionTasks tmp = new SolutionTasks();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual = tmp.maxProfit(prices);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest() {
        SolutionTasks tmp = new SolutionTasks();
        ListNode starting = new ListNode(1);
        starting.add(2);
        starting.add(3);
        starting.add(4);
        starting.add(5);
        ListNode reverse = new ListNode(5);
        reverse.add(4);
        reverse.add(3);
        reverse.add(2);
        reverse.add(1);
        ListNode expected = reverse;
        ListNode actual = tmp.reverse(starting);
        Assert.assertEquals(expected, actual);
    }
}
