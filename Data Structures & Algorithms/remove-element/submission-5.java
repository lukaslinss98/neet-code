class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int i = 0;
        while (i < nums.length){
           int temp = nums[i];
           nums[i] = nums[k];
           nums[k] = temp;
           if(nums[k] != val){
            k++;
           }
           i++;
        }
        return k;
    }
}