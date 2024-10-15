package com.dsalgo.divideAndConquer;

/**
 * Time complexity : O(n^2 * log n)
 * Space complexity : O(n^2)
 * Time Complexity
 * 	1.	Dividing the Grid:
 * 	•	Each step divides the grid into 4 smaller grids.
 * 	•	For a grid of size N x N, this continues until each grid is 1 x 1.
 * 	•	The total number of levels is log₂(N).
 * 	2.	Work at Each Level:
 * 	•	At each level, we process all cells, which is N x N work (since we check each cell).
 * 	3.	Total Time Complexity:
 * 	•	The total work is N² (processing all cells) times log N levels of division.
 * 	•	Final Time Complexity: O(N² log N).
 *
 * Space Complexity
 *
 * 	1.	Recursion Stack:
 * 	•	The recursion depth is log₂(N), so the space used by the recursion stack is O(log N).
 * 	2.	Nodes in Quad Tree:
 * 	•	In the worst case, each cell forms its own node, requiring N x N nodes.
 * 	•	Final Space Complexity: O(N²) for storing nodes.
 */
public class ConstructQuadTree {

    //We can build the quadtree recursively
    public Node construct(int[][] grid) {

        //Start from first row and first col position(0,0) and length was grid.length
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        //Base case if the quadrant region having all 0's or 1's then we can consider it as leaf node and does not have any childern
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        //Now divide the entire region in to two parts
        int halfSize = size / 2;

        //Now we divide in to two parts and in that two parts one part is topLeft and topRight
        //and another part was bottomLeft and bottomRight
        Node topLeft = build(grid, row, col, size);
        Node topRight = build(grid, row, col + halfSize, size); // increasing col size
        Node bottomLeft = build(grid, row + halfSize, col, size); // Increasing row size
        Node bottomRight = build(grid, row + halfSize, col + halfSize, size);//increasing both col and row size

        //if we does not have all values equal then we can consider that as nonleaf node and eligible for further division
        Node node = new Node();
        node.isLeaf = false;
        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
        return node;
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        //Now iterate with in the range by adding the size
        for (int i = row; i < row + size; i++) {
            for (int j = row; j < col + size; j++) {
                if (grid[row][col] != val) {
                    return false;
                }
            }
        }
        return true;
    }


}

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
