class Solution {
  public void sortColors(int[] nums) {
    int[] buckets = {0, 0, 0};

    for(int num : nums){
      buckets[num] = buckets[num] + 1;
    }

    int i = 0;
    for (int j = 0; j < buckets.length; j++) {
      for (int k = 0; k < buckets[j]; k++) {
       nums[i] = j;
       i++;
      }
    }
  }

}