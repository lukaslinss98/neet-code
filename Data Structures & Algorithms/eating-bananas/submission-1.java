class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int eatingRate = 1;

    while (true) {
      long hours = 0;
      for (int pile : piles) {
        int hoursNeeded = Math.ceilDiv(pile, eatingRate);
        hours += hoursNeeded;
      }
      if (hours <= h) {
        break;
      }
      eatingRate++;
    }
    return eatingRate;
  }

}
