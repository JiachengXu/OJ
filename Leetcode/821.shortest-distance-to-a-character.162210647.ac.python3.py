class Solution:
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        positions = []
        for i, c in enumerate(S):
            if c == C:
                positions.append(i)
        res = []        
        for i, c in enumerate(S):        
            mindist = len(S)
            for pos in positions:
                mindist = min(mindist, abs(pos-i))
            res.append(mindist)    
        return res    
            
                

