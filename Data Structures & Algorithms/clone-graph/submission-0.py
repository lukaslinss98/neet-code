"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self,node: Optional["Node"]) -> Optional["Node"]:
        if not node:
            return None
    
        old_to_new = {}
        return self.dfs(node, old_to_new)
    
    
    def dfs(self, node, old_to_new):
        copy = Node(node.val, [])
        old_to_new[node] = copy
    
        for n in node.neighbors:
            if n in old_to_new:
                copy.neighbors.append(old_to_new[n])
            else:
                n_copy = self.dfs(n, old_to_new)
                old_to_new[n] = n_copy
                copy.neighbors.append(n_copy)
    
        return copy


    
 