class Solution {
  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (seen.contains(nums[i])) {
        continue;
      }

      seen.add(nums[i]);

      int lPtr = i + 1;
      int rPtr = nums.length - 1;

      Set<Integer> seenInner = new HashSet<>();
      while (lPtr < rPtr) {
        int num1 = nums[i];
        int num2 = nums[lPtr];
        int num3 = nums[rPtr];

        int sum = num1 + num2 + num3;

        if (seenInner.contains(num3) || sum > 0) {
          rPtr--;
        } else if (seenInner.contains(num2) || sum < 0) {
          lPtr++;
        } else {
          res.add(List.of(num1, num2, num3));
          lPtr++;
          rPtr--;

          seenInner.add(num2);
          seenInner.add(num3);
        }
      }
    }
    return res;
  }


}
