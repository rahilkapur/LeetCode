# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: #if either of lists are empty we've gone through subtree
            return None
        root = TreeNode(preorder[0]) #root of subtree will always be preorder[0]
        mid = inorder.index(preorder[0]) #finding value in inorder array to split it
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid]) #building subtrees here by spliting both lists accordingly so in left only the left subtree values are passed in preorder and for inorder same respectively for right subtree as well just flipped only right subtree elements
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root;