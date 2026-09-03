class Solution:
    def encode(self, strs: List[str]) -> str:

        lengths = ""
        for s in strs:
            lengths += "," if len(lengths) > 0 else lengths
            lengths += str(len(s))

        lengths += "__"

        return lengths + "".join(strs)

    def decode(self, s: str) -> List[str]:
        lenghts, encoded = s.split("__")

        res = []
        if not lenghts:
            return res

        for length in lenghts.split(","):
            length = int(length)
            res.append(encoded[0:length])
            encoded = encoded[length:]
        return res
