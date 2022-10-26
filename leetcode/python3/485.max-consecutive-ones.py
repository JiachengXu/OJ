class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count = 0
        count_max = 0
        n = len(nums)
        for i in range(n):
            if nums[i] == 1:
                count += 1
                if count > count_max:
                    count_max = count
            else:
                count = 0
        return count_max
