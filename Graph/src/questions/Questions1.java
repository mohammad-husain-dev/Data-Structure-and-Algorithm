package questions;

public class Questions1 {
}

/*
1. Check if a Graph is a Tree
   Given an undirected graph, determine if it forms a valid tree.

    Key ideas:
    Graph must be connected
    Number of edges = 𝑛−1
    No cycles

Test Case 1
n = 4
edges = [[0,1],[1,2],[2,3]]
Result: true

Test Case 2
n = 5
edges = [[0,1],[0,2],[0,3],[0,4]]
Result: true

Test Case 3
n = 4
edges = [[0,1],[1,2],[2,3],[3,0]]
Result: false

Test Case 4
n = 4
edges = [[0,1],[2,3]]
Result: false

Test Case 5
n = 4
edges = [[0,1],[1,2]]
Result: false

Test Case 6
n = 3
edges = [[0,1],[1,2],[2,0]]
Result: false

Test Case 7
n = 1
edges = []
Result: true

Test Case 8
n = 2
edges = []
Result: false

Test Case 9
n = 2
edges = [[0,1]]
Result: true

Test Case 10
n = 3
edges = [[0,0],[1,2]]
Result: false

Test Case 11
n = 3
edges = [[0,1],[0,1]]
Result: false

Test Case 12
n = 3
edges = [[0,1],[0,1],[1,2]]
Result: false

Test Case 13
n = 5
edges = [[0,1],[2,3],[3,4],[4,2]]
Result: false

Test Case 14
n = 4
edges = [[2,3],[1,2],[0,1]]
Result: true

Test Case 15
n = 7
edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[4,6]]
Result: true
 */
