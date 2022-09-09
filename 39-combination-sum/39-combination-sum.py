class Solution:
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        combination = []
        sol = []
        amount = 0
        def backtrack(index, amount, combination):
            if index >= len(candidates) or (amount > target):
                return
            if (amount == target):
                sol.append(combination.copy())
                return
            #decision tree: include current element or skip it and don't add anything
            combination.append(candidates[index])
            amount += candidates[index]
            backtrack (index, amount, combination)
            combination.pop()
            amount -= candidates[index]
            backtrack(index + 1, amount, combination)
        backtrack(0, 0, [])
        return sol