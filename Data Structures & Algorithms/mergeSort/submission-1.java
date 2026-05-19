// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
  public List<Pair> mergeSort(List<Pair> pairs) {
    if (pairs.size() <= 1) {
      return pairs;
    }

    int middle = pairs.size() / 2;
    List<Pair> left = pairs.subList(0, middle);
    List<Pair> right = pairs.subList(middle, pairs.size());

    List<Pair> leftSorted = mergeSort(left);
    List<Pair> rightSorted = mergeSort(right);

    return merge(leftSorted, rightSorted);
  }

  private List<Pair> merge(List<Pair> left, List<Pair> right) {

    int ptrL = 0;
    int ptrR = 0;

    List<Pair> result = new ArrayList<>();
    while (ptrL < left.size() || ptrR < right.size()) {
      if (ptrL >= left.size()) {
        result.add(right.get(ptrR));
        ptrR++;
      } else if (ptrR >= right.size()) {
        result.add(left.get(ptrL));
        ptrL++;
      } else {
        if (left.get(ptrL).key <= right.get(ptrR).key) {
          result.add(left.get(ptrL));
          ptrL++;
        } else {
          result.add(right.get(ptrR));
          ptrR++;
        }
      }
    }

    return result;
  }

}
