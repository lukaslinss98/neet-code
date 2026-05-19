class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int min = nums[0];
        int removedCount = 0;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == min){
                nums[i] = -101;
                removedCount++;
           } else {
            min = nums[i];
           }
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 1; i < nums.length; i++){
           if(nums[i] == -101) {
                for(int j = i +1; j < nums.length; j++){
                    if(nums[j] != -101) {
                        nums[i] = nums[j];
                        nums[j] = -101;
                        break;
                    }
                }
           }
        }
       
        return nums.length - removedCount;
    }
}