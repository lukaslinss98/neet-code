class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) { 
            res[i] = productExcludingSelf(nums, i);
        }
        return res;
    }

    private int productExcludingSelf(int[] arr, int indexSelf){
        int product = 1; 

        for (int i = 0; i < arr.length; i++) {
            if(i == indexSelf){
                continue;
            }
            product *= arr[i];
        }
        return product;
    }
        
} 
 
