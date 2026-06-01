class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    for (int i = 2; i < nums.length; i++) {
      for (int j = 1; j < i; j++) {
        for (int k = 0; k < j; k++) {
          int num_i = nums[i];
          int num_j = nums[j];
          int num_k = nums[k];

          if (num_i + num_j + num_k == 0) {
            List<Integer> comb = List.of(num_i, num_j, num_k).stream().sorted().toList();
            res.add(comb);
          }
        }
      }
    }
    return res.stream().toList();
  }
}
