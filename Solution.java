/*Q1. Given an integer array arr and an integer k, return true if it is

possible to divide the vector

into k non-empty subsets with equal
sum.

Input:
Output:
Explanation :
arr = [1,3,2,2] k = 2
true
1 + 3 and 2+2 are two subsets with equal sum. */

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % k != 0) {
            return false;
        }

        int targetSum = totalSum / k;
        boolean[] visited = new boolean[nums.length];

        return dfs(nums, visited, 0, k, 0, targetSum);
    }

    private boolean dfs(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int targetSum) {
        if (k == 1) {
            return true;
        }

        if (currentSum == targetSum) {
            return dfs(nums, visited, 0, k - 1, 0, targetSum);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (dfs(nums, visited, i + 1, k, currentSum + nums[i], targetSum)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2};
        int k = 2;
        Solution solution = new Solution();
        boolean result = solution.canPartitionKSubsets(arr, k);
        System.out.println(result);  // Output: true
    }
}
