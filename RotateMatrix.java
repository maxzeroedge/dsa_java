public class RotateMatrix {
    
    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start_i = -1;
        int start_j = -1;
        int end_i = m;
        int end_j = n;
        int i = -1;
        int j = -1;
        while(i+2 < m && j+2 < n) {
            start_i += 1;
            start_j += 1;
            end_i -= 1;
            end_j -= 1;
            i += 1;
            j += 1;
            int prev = matrix[i+1][j];
            int curr = matrix[i][j];
            while( i++ < end_i) {
                curr = matrix[i][j];
                matrix[i][j] = prev;
                prev = curr; 
            }
            // i == end_i now
            i--;
            while(j++ < end_j) {
                curr = matrix[i][j];
                matrix[i][j] = prev;
                prev = curr;
            }
            j--;
            // j == end_j now
            while( i-- > start_i ) {
                curr = matrix[i][j];
                matrix[i][j] = prev;
                prev = curr;
            }
            i++;
            // i == start_i now
            while( j-- > start_j ) {
                curr = matrix[i][j];
                matrix[i][j] = prev;
                prev = curr;
            }
            j++;
            // j == start_j now
        }
    }

    public static void main(String[] args) {
        int a[][] = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.print(String.format("%02d ", a[i][j]));
            }
            System.out.println("");
        }
        System.out.println("");
        rotateMatrix(a);
        System.out.println("");
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.print(String.format("%02d ", a[i][j]));
            }
            System.out.println("");
        }
    }
}
