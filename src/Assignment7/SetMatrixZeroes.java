package Assignment7;

/**
 * 73. Set Matrix Zeroes
 * <p>
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        boolean colB = false;
        boolean rowB = false;

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){

                if(matrix[i][j] == 0 ){
                    if(j == 0){
                        colB = true;
                    }
                    if(i == 0){
                        rowB = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix[0].length-1; i >0; i--){
            if(matrix[0][i] == 0){
                for(int m = 0; m < matrix.length;m++){
                    matrix[m][i] = 0;
                }
            }
        }

        for(int i = matrix.length-1; i >0; i--){
            if(matrix[i][0] == 0){
                for(int m = 0; m < matrix[0].length; m++){
                    matrix[i][m] = 0;
                }
            }
        }

        if(matrix[0][0]==0){
            if(colB){
                for(int n = 0 ; n < matrix.length; n++){
                    matrix[n][0]=0;
                }
            }

            if(rowB){
                for( int m = 0; m < matrix[0].length; m++){
                    matrix[0][m] = 0;
                }
            }

        }
    }
}
