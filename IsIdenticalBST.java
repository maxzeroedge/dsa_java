// Check Identical BST Without Building Trees
public class IsIdenticalBST {

    public static boolean checkBSTIdentical(int[] a, int[] b, int ai, int bi, int min, int max) {
        int i, j;
        for(i = ai; i < a.length; i++) {
            if(a[i] > min && a[i] < max) {
                break;
            } 
        }
        for(j = bi; j < a.length; j++) {
            if(a[j] > min && a[j] < max) {
                break;
            } 
        }

        // Check for leaf nodes
        if(i == a.length && j == b.length) {return true;}
        
        if( (i == a.length && j != b.length) || (i != a.length && j == b.length) || a[i] != b[j]) {
            return false;
        }
	return checkBSTIdentical(a, b, ai+1, bi+1, a[i], max) && checkBSTIdentical(a, b, ai+1, bi+1, min, a[i]);
    }

    public static void main(String[] args) {

        int[] a = new int[]{8, 3, 4, 1, 6, 7, 10, 13, 14};
        int[] b = new int[]{8, 13, 14, 3, 4, 1, 6, 7, 10};
        System.out.println(checkBSTIdentical(a, b, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}