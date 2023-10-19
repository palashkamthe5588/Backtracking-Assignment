/*

Q3. Given a collection of numbers, nums, that might containduplicates, return all possible  unique permutations in any order. 
Example 1: 

Input:  
nums = [1,1,2] 

Output: 
[[1,1,2], [1,2,1], 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        // Sort the input array to make duplicates adjacent.
        Arrays.sort(nums);

        generateUniquePermutations(nums, used, currentPermutation, result);

        return result;
    }

    private void generateUniquePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(nums[i]);
            generateUniquePermutations(nums, used, currentPermutation, result);
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        UniquePermutations uniquePermutations = new UniquePermutations();
        List<List<Integer>> result = uniquePermutations.permuteUnique(nums);

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
