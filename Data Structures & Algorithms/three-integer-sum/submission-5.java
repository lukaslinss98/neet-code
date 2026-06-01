class Solution {
  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int lPtr = i + 1;
      int rPtr = nums.length - 1;

      while (lPtr < rPtr) {
        int num1 = nums[i];
        int num2 = nums[lPtr];
        int num3 = nums[rPtr];

        int sum = num1 + num2 + num3;

        if (sum > 0) {
          rPtr--;
        } else if (sum < 0) {
          lPtr++;
        } else {
          res.add(List.of(num1, num2, num3));
          lPtr++;
          rPtr--;
          while (nums[lPtr] == nums[lPtr - 1] && lPtr < rPtr) lPtr++;
        }
      }
    }
    return res;
  }

}
