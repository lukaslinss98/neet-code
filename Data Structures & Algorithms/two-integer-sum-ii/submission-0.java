class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> indexByPair = new HashMap<>();

        for (int i = 0; i <= numbers.length; i++) {

            int pair = target - numbers[i];
            Integer indexOfPair = indexByPair.get(pair);
            if (indexOfPair != null) {
                return new int[] {indexOfPair + 1, i + 1};
            }

            indexByPair.put(numbers[i], i);
        }

        return new int[]{};
    }
}
