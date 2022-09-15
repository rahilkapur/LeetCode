class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        sol = []
        nums.sort()
        def backtrack(ind, temp):
            if ind == len(nums):
                sol.append(temp[::])
                return
            #decision tree two options add curr or not
            temp.append(nums[ind])
            backtrack(ind + 1, temp)
            num = temp.pop()
            index = ind
            #check if next num is same as one before, if so then skip it
            while index < len(nums) and nums[index] == num:
                index += 1
            
            backtrack(index, temp)
        
        backtrack(0, [])
        return sol
                
        