import math

# class Solution:
#     def plusOne(self, digits: List[int]) -> List[int]:
#         n = len(digits)
#         p = 1
#         num = 0
#         while n>0:
#             num += digits[n-1]*p
#             p *= 10
#             n -= 1
#         num += 1
#         result = []
#         while num>=1:
#             result.insert(0,num%10)
#             num = math.floor(num/10)
#         return result


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        # if n==1:
        #     if digits[0]!=9:
        #         digits[0] += 1
        #         return digits
        #     else:
        #         digits[0]=0
        #         digits.insert(0,1)
        #         return digits
        while n > 1:
            if digits[n - 1] != 9:
                digits[n - 1] += 1
                return digits
            else:
                digits[n - 1] = 0
                n -= 1
        if digits[0] != 9:
            digits[0] += 1
            return digits
        else:
            digits[0] = 0
            digits.insert(0, 1)
            return digits
