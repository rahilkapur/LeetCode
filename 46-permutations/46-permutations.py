class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        sol = [] #will hold solution
        
        if (len(nums) == 1):
            return [nums[:]]
        
        for i in range(len(nums)):
            num = nums.pop(0)
            permuts = self.permute(nums)
            for p in permuts:
                p.append(num)
            sol.extend(permuts)
            nums.append(num)
        return sol