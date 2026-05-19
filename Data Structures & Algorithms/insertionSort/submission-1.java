// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
  public List<List<Pair>> insertionSort(List<Pair> pairs) {
    if(pairs.isEmpty()){
      return List.of();
    }

    List<List<Pair>> steps = new ArrayList<>();
    steps.add(new ArrayList<>(pairs));
    for (int i = 1; i < pairs.size(); i++) {
      int j = i - 1;
      while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
        pairs.add(j, pairs.get(j + 1));
        pairs.remove(j + 2);
        j--;
      }
      steps.add(new ArrayList<>(pairs));
    }
    return steps;
  }

}
