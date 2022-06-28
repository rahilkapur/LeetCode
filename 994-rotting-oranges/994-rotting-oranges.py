class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        rows = len(grid)
        cols = len(grid[0])
        mins = 0
        fresh = 0
        for r in range(rows):
            for l in range(cols):
                if (grid[r][l] == 2):
                    q.append([r, l])
                if (grid[r][l] == 1):
                    fresh += 1
                    
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q and fresh > 0:
            for i in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    row = dr + r
                    col = dc + c
                    if (row < 0 or row == len(grid) or col < 0 or 
                        col == len(grid[0]) or grid[row][col] != 1):
                        continue
                    grid[row][col] = 2
                    q.append([row, col])
                    fresh -= 1
            mins += 1
        if (fresh != 0):
            return -1
    
        return mins