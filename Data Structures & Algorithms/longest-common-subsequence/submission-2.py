class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.subsequence(text1, text2, 0, 0, {})

    def subsequence(
        self, text1: str, text2: str, ptr1: int, ptr2: int, memo: dict
    ) -> int:
        if ptr1 >= len(text1) or ptr2 >= len(text2):
            return 0

        if (ptr1, ptr2) in memo:
            return memo[(ptr1, ptr2)]


        if text1[ptr1] == text2[ptr2]:
            memo[(ptr1, ptr2)] = 1 + self.subsequence(
                text1, text2, ptr1 + 1, ptr2 + 1, memo
            )
            return memo[(ptr1, ptr2)]

        memo[(ptr1 + 1, ptr2)] = self.subsequence(text1, text2, ptr1 + 1, ptr2, memo)
        memo[(ptr1, ptr2 + 1)] = self.subsequence(text1, text2, ptr1, ptr2 + 1, memo)

        return max(memo[(ptr1 + 1, ptr2)], memo[(ptr1, ptr2 + 1)])
