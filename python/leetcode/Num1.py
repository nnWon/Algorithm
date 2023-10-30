class Solution(object):
    def twoSum(self, nums, target):
        map = {}
        for index, n in enumerate(nums) :
            map[n] = index
        for index, n in enumerate(nums) :
            key = target - n
            if key != n and map.get(key) is not None :
                return (index,map.get(key))
        return(0,0)
    

'''
s =Solution()
print(s.twoSum(nums = [2,7,11,15], target = 9))
print(s.twoSum(nums = [3,2,4], target = 6))
print(s.twoSum(nums = [3,3], target = 6))
'''
