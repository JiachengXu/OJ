class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)
        if (m==0): return 0
        if (m>n):return -1
        for i in range(n-m+1):
            for j in range(m):
                if haystack[i+j]!=needle[j]:
                    break
            else: return i
        return -1
                    