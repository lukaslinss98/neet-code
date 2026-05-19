// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
  public List<Pair> quickSort(List<Pair> pairs) {
    if (pairs.size() <= 1) {
      return pairs;
    }

    int insert = 0;
    int pivot = pairs.getLast().key;

    for (int i = 0; i < pairs.size() - 1; i++) {
      if (pairs.get(i).key < pivot) {
        Collections.swap(pairs, i, insert);
        insert++;
      }
    }

    Collections.swap(pairs, insert, pairs.size() - 1);

    List<Pair> left = pairs.subList(0, insert);
    List<Pair> right = pairs.subList(insert + 1, pairs.size());

    quickSort(left);
    quickSort(right);

    return pairs;
  }

}
