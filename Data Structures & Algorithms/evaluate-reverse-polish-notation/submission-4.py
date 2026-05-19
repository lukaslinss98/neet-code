class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = ['+', '-', '*', '/']
        res = 0
        stack = []

        for token in tokens:
            print(stack)
            if token not in operators:
                stack.append(int(token))

            else: 
                last_num = stack.pop()
                second_to_last_num = stack.pop()

                expression = f"{second_to_last_num} {token} {last_num}"
                res = int(eval(expression))
                stack.append(res)


        return stack.pop()
        
 
        
