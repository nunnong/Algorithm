import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] line = a.toCharArray();
        
        for (char c : line) {
            System.out.println(c);
        }
    }
}