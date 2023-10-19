
/*Q2. Given an integer array arr, print all the possible permutations ofthe given array. Note : The array will only contain non repeating elements. 

Input 1  
:  
arr = [1, 2, 3] 

Output1 : 
  
[[1,2,3] , [1,3,2] , [2,1,3] , [2,3,1] , [3,1,2] , [3,2,1]]  */



import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        generatePermutations(nums, used, currentPermutation, result);

        return result;
    }

    private void generatePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(nums[i]);
                generatePermutations(nums, used, currentPermutation, result);
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(arr);

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}

