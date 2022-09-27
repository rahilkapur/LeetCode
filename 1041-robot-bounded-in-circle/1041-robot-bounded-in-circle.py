class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dirX, dirY = 0, 1 #we are currently facing north
        x, y = 0, 0
        
        for di in instructions:
            if di == "G":
                x, y = x + dirX, y + dirY
            elif di == "L":
                dirX, dirY = -1 * dirY, dirX
            else:
                dirX, dirY = dirY, -1 * dirX
        
        return (x, y) == (0, 0) or (dirX, dirY) != (0, 1)
                