import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Museum{
    public static void main(String[] args){

        ArrayList<Art> museum = new ArrayList<Art>();

        Painting paint1 = new Painting();
        museum.add(paint1);
        Painting paint2 = new Painting();
        museum.add(paint2);
        Painting paint3 = new Painting();
        museum.add(paint3);

        Sculpture sculpt1 = new Sculpture();
        museum.add(sculpt1);
        Sculpture sculpt2 = new Sculpture();
        museum.add(sculpt2);



            int i = 0;
            if (i == 0){
            while (i < museum.size()){
                museum.get(i).viewArt();
                i++;
            }
        }
    }

    public void shuffleMuseum(ArrayList<Art> list){
        Random randomGenerator = new Random();
        int[] stream = this.intStream(randomGenerator);
        int repetitionSelector = randomGenerator.nextInt(100);
        int repetitions = stream[repetitionSelector];
        System.out.println(repetitions);

        int size = list.size();
        int getIndex;
        int setIndex;

        while (repetitions > 0){
            getIndex = randomGenerator.nextInt(size);
            setIndex = randomGenerator.nextInt(size);

        
            Art temp1 = list.get(getIndex);
            Art temp2 = list.get(setIndex);
            list.set(setIndex, temp1);
            list.set(getIndex, temp2);
            repetitions--;
        }
    }

    public int[] intStream(Random random){
        IntStream stream = random.ints(100, 1, 100);
        int[] list = stream.toArray();
        return list;
    }

}