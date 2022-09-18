import java.util.*;
import java.util.stream.IntStream;


public class PuzzleJava{
    
    Random randomGenerator = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> rolls = new ArrayList<Integer>(); 
        int i = 0;
        int x;
        while (i < 10){
            x = randomGenerator.nextInt(20) + 1;
            rolls.add(x);
            i++;
        }
        return rolls;
    }

    public char getRandomLetter(){
        char[] alphabet = new char[26];
        for(char ch = 'A'; ch <= 'Z'; ch++)
        {
            alphabet[ch-'A']=ch;
        }

        int x = randomGenerator.nextInt(26);
        return alphabet[x];
    }

    public String generatePassword(){
        int i =0;
        String password = "";
        while (i < 8){
            char x = getRandomLetter();
            password += x;
            i++;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int x){
        ArrayList<String> passwordSet = new ArrayList<String>();

        for (int i = 0; i < x; i++){
            passwordSet.add(this.generatePassword());
        }
        return passwordSet;
    }

    public ArrayList<String> shufflePasswordSet(ArrayList<String> list){
        int[] stream = this.intStream();

        int repetitionSelector = randomGenerator.nextInt(100);

        int repetitions = stream[repetitionSelector];
        System.out.println(repetitions);

        int size = list.size();
        int getIndex;
        int setIndex;

        while (repetitions > 0){
            getIndex = randomGenerator.nextInt(size);
            setIndex = randomGenerator.nextInt(size);

        
            String temp1 = list.get(getIndex);
            String temp2 = list.get(setIndex);
            list.set(setIndex, temp1);
            list.set(getIndex, temp2);
            repetitions--;
        }
        return list;
    }

    public int[] intStream(){
        IntStream stream = randomGenerator.ints(100, 1, 100);
        int[] list = stream.toArray();
        return list;
    }
}