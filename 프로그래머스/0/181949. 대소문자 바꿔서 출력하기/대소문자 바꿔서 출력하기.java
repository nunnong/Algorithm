import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] chars = a.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : chars) {
            char word = c;
            sb.append(Character.isUpperCase(word) ? Character.toLowerCase(word) : Character.toUpperCase(word));
        }
        
        System.out.println(sb.toString());
    }
}