class Solution(object):
    def longestConsecutive(self, nums):
        map ={}
        for number in nums :
            map[number] = True
        
        result = 0
        for key in map.keys() :
            count = 0
            pre = key -1
            if not map.get(pre) :
                while map.get(key) :
                    count +=1
                    key +=1
            if result < count :
                result = count
        return result
    
s = Solution()
print(s.longestConsecutive([100,4,200,1,3,2]))
print(s.longestConsecutive([0,3,7,2,5,8,4,6,0,1]))
