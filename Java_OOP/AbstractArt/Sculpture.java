public class Sculpture extends Art{
    private String material;

    public Sculpture(){
        this.setTitle();
        this.setAuthor();
        this.setDescription();
        this.setMaterial();
    }
    public void viewArt(){
        System.out.println("" + getTitle() + " by: " + getAuthor() + "\nDescription: "+getDescription() + "\n --(Painted with: " + getMaterial() + ")");
    }

    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(){
        System.out.println("What kind of material did you use?");
        this.material = System.console().readLine();
    }
}