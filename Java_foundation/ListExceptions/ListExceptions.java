import java.util.*;
class errorException extends Exception{}

class ListExceptions{
    public void exceptions(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer)myList.get(i);
                }
            catch(Exception e){
                // System.out.println("Error" + e);
                System.out.println(e +": *You cannot cast the item at index: " + i + " --value: (" + myList.get(i).getClass() + ") " + myList.get(i));
                }
    }
}
}