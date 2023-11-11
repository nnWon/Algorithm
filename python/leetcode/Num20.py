class Solution(object):
    
    def isValid(self, s):
        stack = []
        for c in s :
            if c == "(" :
                stack.append(")")
            elif c == "{" :
                stack.append("}")
            elif c == "[" :
                stack.append("]")
            elif len(stack) == 0 or stack.pop() != c :
                return False 
        return len(stack) == 0

s = Solution()
print(s.isValid("()"))