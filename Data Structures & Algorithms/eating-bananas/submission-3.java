class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int lower = 1;
    int upper = IntStream.of(piles).max().orElseThrow();

    int min = upper;
    while (lower <= upper) {
      int eatingRate = (upper + lower) / 2;
      System.out.println("lower %s, upper %s, rate %s".formatted(lower, upper, eatingRate));
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