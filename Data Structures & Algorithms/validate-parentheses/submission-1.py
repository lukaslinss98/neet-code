class Solution:
    def isValid(self, s: str) -> bool:
        open_brackets = ['(', '{', '[']
        close_brackets = [')', '}', ']']
        stack = []

        for c in s: 
            if c in open_brackets:
                stack.append(c)
            if c in close_brackets:
                if len(stack) == 0:
                    return False
                
                poped_el = stack.pop()
                index_poped_el = open_brackets.index(poped_el)
                index_char = close_brackets.index(c)

                if index_poped_el != index_char:
                    return False

        return len(stack) == 0
