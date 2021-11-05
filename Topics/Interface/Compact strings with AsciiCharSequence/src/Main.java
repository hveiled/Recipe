import java.util.*;
import java.lang.CharSequence;
import java.util.stream.IntStream;

class AsciiCharSequence implements CharSequence /* extends/implements */ {

    byte[] arr;

//    public static void main(String[] args) {
//        byte[] arr = {'a', 'b', 'c'};
//        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(arr);
//        System.out.println(asciiCharSequence.length());
//        System.out.println(asciiCharSequence.charAt(0));
//        System.out.println(asciiCharSequence.subSequence(2,2));
//        System.out.println(asciiCharSequence.toString());
//    }

    public AsciiCharSequence(byte[] arr) {
        this.arr = arr;
    }

    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public char charAt(int i) {
        return (char) arr[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] ar = new byte[i1 - i];
        AsciiCharSequence cs = new AsciiCharSequence(ar);

        if (i == i1) {
            return cs;
        }

        for (int j = i, k = 0; j < i1; j++) {
            cs.arr[k] = arr[j];
            k++;
        }
        return cs;
    }

    @Override
    public String toString() {
        String str = "";
        for (byte b : arr) {
            str += (char)b;
        }
        return str;
    }

    // implementation
}