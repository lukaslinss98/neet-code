class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty())
            return "";

        return strs
        .stream()
        .collect(Collectors.joining(";"));

    }

    public List<String> decode(String str) {
        if(str == "")
            return List.of();

        return List.of(str.split(";"));
    }
}
