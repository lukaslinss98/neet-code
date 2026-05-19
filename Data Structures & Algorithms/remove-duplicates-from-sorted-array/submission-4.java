class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int uniqueIndex = 1;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
           if(nums[i] > min){
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
                min = nums[i];
           }
        }
        for(int i = uniqueIndex +1; i < nums.length; i++){
            nums[i] = 0;
        }

        return uniqueIndex;
    }
}