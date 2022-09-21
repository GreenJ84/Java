class Gorilla extends Mammal{

    public void throwSomething(){
        System.out.println("Gorilla has thrown an item!");
        energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("Gorilla is very happy after eating a banana!");
        energyLevel += 10;
    }

    public void climb(){
        System.out.println("Gorilla has climbed a tree!");
        energyLevel -= 10;
    }
}