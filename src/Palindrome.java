/**
 * Check if number is a palindrome without using extra space
 */
import java.io.*;
public class Palindrome{
    static int num = 212213;
    public static void main(String[] args) throws IOException{
        if(isPalindrome(num)){
            System.out.println("Number is a palindrome");
        }
        else
            System.out.println("Number is not a palindrome");
    }
    /**
     * 
     * @param n number to be checked if palindrome or not
     * @return true is n is palindrome, false otherwise
     */
    public static boolean isPalindrome(int n){
        int div = 10;
        while(n/div >= 10)
            div *= 10;
        while(true){
        	if(div <= 1)
        		return true;
            if(n/div != n%10)
                return false;
            // remove the first digit of the number
            n = n - ((n%10) * div);
            // Remove the last digit of the number
            n = n/10;
            // reduce div by 100 times as number is decreased by 2 digits
            div /= 100;
        }
    }
}