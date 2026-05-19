class Solution {
    public int[] getConcatenation(int[] nums) {
        int inputLength = nums.length;
        int[] ans = new int[inputLength * 2];

        for(int i = 0; i < nums.length;i++){
            ans[i] = nums[i];
            ans[i + inputLength] = nums[i];
        }
        return ans;
    }
}