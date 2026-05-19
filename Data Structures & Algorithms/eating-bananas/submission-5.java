class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int lower = 1;
    int upper = IntStream.of(piles).max().orElseThrow();

    int min = upper;
    while (upper >= lower) {
      int eatingRate = (upper + lower) / 2;
      long hours = 0;
      for (int pile : piles) {
        hours += Math.ceilDiv(pile, eatingRate);
      }
      if (hours > h) {
        lower = eatingRate + 1;
      } else {
        upper = eatingRate - 1;
        min = eatingRate;
      }
    }
    return min;
  }
}