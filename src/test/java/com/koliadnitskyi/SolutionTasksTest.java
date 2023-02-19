package com.koliadnitskyi;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTasksTest {
    @Test
    public void polydromeTest() {
        String str = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean actual = SolutionTasks.polydrome(str);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pduplicateeTest() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean expected = true;
        boolean actual = SolutionTasks.duplicate(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] actual = SolutionTasks.sum(nums, target);
        Assert.assertArrayEquals(expected, actual);
    }
}