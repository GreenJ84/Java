import java.util.*;
import java.util.stream.IntStream;
public class PuzzleTest{
    public static void main(String[] args){
        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        char selectedChar = generator.getRandomLetter();
        System.out.println(selectedChar);

        String myPassword = generator.generatePassword();
        System.out.println(myPassword);

        ArrayList<String> passwordSet = generator.getNewPasswordSet(6);
        System.out.println(passwordSet);

        generator.shufflePasswordSet(passwordSet);
        System.out.println(passwordSet);


        
    }
}