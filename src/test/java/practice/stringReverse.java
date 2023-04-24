package practice;

import org.testng.annotations.Test;

import java.util.Scanner;

public class stringReverse {

    @Test
    public void stringReverse(){
        System.out.println("Please enter a word");
        Scanner scanner = new Scanner(System.in);
        String enteredWord = scanner.nextLine();

        String reversedWord = "";

        // converting the String to Char[]
        char[] wordArray = enteredWord.toCharArray();

        //Loop in reverse and stored in reservedWord

        for (int i = wordArray.length-1; i >=0; i--)
        {
            reversedWord += wordArray[i];
        }
        System.out.println("The reversed word: " + reversedWord);
    }
}
