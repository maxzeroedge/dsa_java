import java.util.*;

public class IsSudokuValid {

    public static void main(String[] args){
        String sa = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 8 0 0 0 0 8 0 0 0 0 0 0 0 0 0 0 7 0 0 0 0 0 0 0 0 7 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
        String sb = "0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 5 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 0 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
        String s1[] = sb.split("\\s+");
        int mat[][] = new int[9][9];
        for(int i = 0;i < 81;i++)
            mat[i/9][i%9] = Integer.parseInt(s1[i]);
        System.out.println(isValid(mat));
    }

    public static boolean rowValid(int[][] match, int constIndex) {
        Set<Integer> numbers = new HashSet<>();
        for(int j = 0; j < match[constIndex].length; j++) {
            if(match[constIndex][j] != 0) {
                if(!numbers.add(match[constIndex][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean columnValid(int[][] match, int constIndex) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; i < match.length; i++) {
            if(match[i][constIndex] != 0) {
                if(!numbers.add(match[i][constIndex])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean blockValid(int[][] match, int i, int j) {
        Set<Integer> numbers = new HashSet<>();
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                if(match[a+i][b+j] != 0) {
                    if(!numbers.add(match[a+i][b+j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int isValid(int[][] mat) {
        for(int i = 0; i < mat.length; i+=3) {
            if(!rowValid(mat, i) || !rowValid(mat, i+1) || !rowValid(mat, i+2)) {
                return 0;
            }
            for(int j = 0; j < mat[i].length; j+=3) {
                if((!columnValid(mat, j) || !columnValid(mat, j+1) || !columnValid(mat, j+2))) {
                    return 0;
                }
                if(!blockValid(mat, i, j)) {
                    return 0;
                }
            }
        }
        /*for(int[] row: mat) {
            for(int col: row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }*/
        return 1;
    }
    
}