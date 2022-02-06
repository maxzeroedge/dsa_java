import java.util.BitSet;

public class NBitGrayCode {
    
    public static String[] generateGray(int n) {
        if(n == 0) {
            return new String[] {"0"};
        } else if(n == 1) {
            return new String[] {"0", "1"};
        }
        String[] previousStrings = NBitGrayCode.generateGray(n-1);
        String[] grayCode = new String[previousStrings.length * 2];
        for(int i = 0; i < previousStrings.length; i++) {
            grayCode[i] = "0" + previousStrings[i];
        }
        for(int i = previousStrings.length - 1; i > -1; i--) {
            grayCode[previousStrings.length + i] = "1" + previousStrings[i];
        }
        return grayCode;
    }

    public static String[] generateGrayBitSet(int n) {
        String[] grayCode = new String[2*n];
        int counter = 0;
        // TODO: Loop never goes in
        for(int i = 0; i < (i << n); i++) {
            int val = i ^ (i>>1);
            BitSet bits = BitSet.valueOf(new long[]{val});
            grayCode[counter] = bits.toString();
            counter++;
        }
        return grayCode;
    }

    public static void main(String[] args) {
        String[] grayCode = NBitGrayCode.generateGray(10);
        for(String s: grayCode) {
            System.out.println(s);
        }
    }
}
