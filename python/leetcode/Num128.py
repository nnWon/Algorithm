class Solution(object):
    def longestConsecutive(self, nums):
        if len(nums) == 0 : return 0
    
        nums.sort()
        result = 0
        pre = nums[0]
        count = 1
        for n in nums :
            if pre == n :
                continue 
            if pre+1 == n :
                count +=1
            else :
                if result < count : 
                    result = count
                count = 1
            pre = n
        if result < count : 
            result = count
        return result
'''
s = Solution()
print(s.longestConsecutive([100,4,200,1,3,2]))
print(s.longestConsecutive([0,3,7,2,5,8,4,6,0,1]))
'''
