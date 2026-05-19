class Solution {
  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start == end) {
      return nums[start] == target ? start : -1;
    }

    int mid = (end + start) / 2;

    int midNum = nums[mid];
    if (midNum == target) {
      return mid;
    } else if (midNum < target) {
      return binarySearch(nums, mid + 1, end, target);
    } else {
      mid = mid > 0 ? mid - 1 : mid;
      return binarySearch(nums, start, mid, target);
    }
  }



}
