class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 1) {
      System.out.println(Arrays.deepToString(matrix));
      return binarySearch(matrix[0], 0, matrix[0].length - 1, target);
    }

    return searchMatrix(matrix, 0, matrix.length - 1, target);

  }

  private boolean searchMatrix(int[][] matrix, int start, int end, int target) {
    if (start == end) {
      return binarySearch(matrix[start], 0, matrix[start].length - 1, target);
    }

    int middle = (start + end) / 2;

    int first = matrix[middle][0];
    int last = matrix[middle][matrix[middle].length - 1];

    if (target >= first && target <= last) {
      return binarySearch(matrix[middle], 0, matrix[middle].length - 1, target);
    } else if (target < first) {
        middle = middle == start ? middle : middle -1;

      return searchMatrix(matrix, start, middle, target);
    } else {
      return searchMatrix(matrix, middle + 1, end, target);
    }
  }

  private boolean binarySearch(int[] nums, int start, int end, int target) {
    if (start == end) {
      return nums[start] == target;
    }

    int mid = (end + start) / 2;

    int midNum = nums[mid];
    if (midNum == target) {
      return true;
    } else if (midNum < target) {
      return binarySearch(nums, mid + 1, end, target);
    } else {
      mid = mid > start ? mid - 1 : mid;
      return binarySearch(nums, start, mid, target);
    }

  }
}
