class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) < 2:
            return False

        stack = []
        pairs = {
            "}": "{",
            "]": "[",
            ")": "(",
        }

        for c in s:
            if c in pairs.values():
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                    
                popped = stack.pop()

                if pairs[c] != popped:
                    return False

        return len(stack) == 0

        