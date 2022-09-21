public class Painting extends Art{
    private String paintType;

    public Painting(){
        setTitle();
        setAuthor();
        setDescription();
        setPaintType();
    }

    public void viewArt(){
        System.out.println("" + getTitle() + " by: " + getAuthor() + "\nDescription: " + getDescription() + "\n --(Painted with: " + getPaintType() + ")");
    }

    public String getPaintType(){
        return this.paintType;
    }

    public void setPaintType(){
            System.out.println("What type of paint was used?");
            this.paintType = System.console().readLine();
    }
}