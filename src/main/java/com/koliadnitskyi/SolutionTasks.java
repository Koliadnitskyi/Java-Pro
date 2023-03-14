package com.koliadnitskyi;

import java.util.Arrays;

public class SolutionTasks {
    public static boolean polydrome(String str) {
        String tmp = str.replaceAll("[!\"()*+,=>?@\\[\\]^_`{|}~ ]", "").toLowerCase();
        return tmp.equals(new StringBuilder(tmp).reverse().toString());
    }

    public static boolean duplicate(int[] nums) {
        return !Arrays.equals(nums, Arrays.stream(nums).distinct().toArray());
    }

    public static int[] sum(int[] nums, int target) {
        int[] tmp = new int[2];
        for (int o = 0; o < nums.length; o++) {
            for (int e = o + 1; e < nums.length; e++) {
                if (nums[o] + nums[e] == target) {
                    tmp[0] = o;
                    tmp[1] = e;
                }
            }
        }
        System.out.println(tmp);
        return tmp;
    }
}
