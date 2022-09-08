class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        sol = []
        subset = []
        def backtrack(i):
            if (i >= len(nums)):
                sol.append(subset.copy())
                return
            #left side of tree, add curr number
            subset.append(nums[i])
            backtrack(i + 1)
            
            #right side of tree, add nothing
            subset.pop()
            backtrack(i + 1)
        backtrack(0)
        return sol
        