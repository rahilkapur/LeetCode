class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        sol = []
        def backtrack(index, temp, cum):
            if cum > target:
                return
            if index >= len(candidates):
                if cum == target:
                    sol.append(temp.copy())
                    return
                return
            if cum == target:
                sol.append(temp.copy())
                return
            
            #decision tree: either add current or skip and go to next index
            
            temp.append(candidates[index])
            backtrack(index + 1, temp, cum + candidates[index])
            
            num = temp.pop()
            ind = index
            while (ind < len(candidates) and candidates[ind] == num):
                ind += 1
            backtrack(ind, temp, cum)
        
        candidates.sort();
        backtrack(0, [], 0)
        return sol
        