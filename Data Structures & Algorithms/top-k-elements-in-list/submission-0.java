class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> frequencyByNum = new HashMap<>();
        for (int i : nums) {
            if(frequencyByNum.containsKey(i)){
                int currentFrequency = frequencyByNum.get(i);
                frequencyByNum.replace(i, currentFrequency + 1);
            } else {
            frequencyByNum.put(i, 1);
            }
        }

        return frequencyByNum.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(entry -> entry.getKey())
                .limit(k)
                .mapToInt(i -> i)
                .toArray();
    }
}
