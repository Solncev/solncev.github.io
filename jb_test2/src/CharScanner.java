import java.util.Scanner;

/**
 * Created by Марат on 25.05.2016.
 */
public class CharScanner {

    public int charIndex(String s) {
        int[] a = new int[256];
        for (int i = 0; i < s.length(); i++){
            a[(int)s.charAt(i)] ++;
        }
        for (int j = 0; j < s.length();j ++){
            if (a[(int)s.charAt(j)] == 1){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CharScanner charScanner = new CharScanner();
        System.out.println(charScanner.charIndex(sc.nextLine()));
    }

}
