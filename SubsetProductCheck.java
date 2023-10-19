/*

Q4. Check if the product of some subset of an array is equal to thetarget value. 

Input : 
 n = 5 , target = 16 

Array = [2 3 2 5 4] 
Here the target will be equal to 2x2x4 = 16 

Output :  
YES 

 */




public class SubsetProductCheck {
    public static boolean isSubsetProductEqualToTarget(int[] arr, int target) {
        return backtrack(0, arr, 1, target);
    }

    private static boolean backtrack(int startIndex, int[] arr, int currentProduct, int target) {
        if (currentProduct == target) {
            return true;
        }

        for (int i = startIndex; i < arr.length; i++) {
            int newProduct = currentProduct * arr[i];
            if (newProduct > target) {
                continue; // Skip if the product exceeds the target.
            }
            if (backtrack(i + 1, arr, newProduct, target)) {
                return true; // If a valid subset is found, return true.
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 4};
        int target = 16;
        boolean result = isSubsetProductEqualToTarget(arr, target);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
