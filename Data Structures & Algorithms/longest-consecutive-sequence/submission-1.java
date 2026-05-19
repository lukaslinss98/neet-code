class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).sorted().forEach(num -> {
            if (map.containsKey(num - 1)) {
                int val = map.get(num - 1) + 1;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        });

       return map.values()
               .stream()
               .max(Integer::compareTo)
               .orElse(0);
    }
}
