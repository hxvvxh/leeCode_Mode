package StringAndChan;

public class setZeroes {
	public static void main(String[] args) {

	}
/**
 * 输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 * @param matrix
 */
	public void test(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/**
	 * leecode最快的方法
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || matrix[0].length == 0) return ;
        int m = matrix[0].length;

        boolean row = false, col = false;

        if (matrix[0][0] == 0) {
            row = true;
            col = true;
        }

        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }

        for (int i = 0; i < m; i++)
            if (matrix[0][i] == 0) {
                col = true;
                break;
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;

        
        if (row) {
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }

        
        if (col) {
            for (int i = 0; i < m; i++) matrix[0][i] = 0;
        }
    }
}
