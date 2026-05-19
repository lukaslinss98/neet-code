class Solution:
    def isValid(self, s: str) -> bool:
        p_dict = {
            '(' : ')',
            '{' : '}',
            '[' : ']'
        }
        stack = []

        for c in s: 
            if c in p_dict.keys():
                stack.append(c)
            if c in p_dict.values():
                if len(stack) == 0:
                    return False
                
                poped_el = stack.pop()
                if p_dict[poped_el] != c:
                    return False


        return len(stack) == 0 

