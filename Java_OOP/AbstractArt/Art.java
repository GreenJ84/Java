import java.util.*;

public abstract class Art{
        private String title;
        private String author;
        private String description;


        public void viewArt(){}

        public String getTitle(){
            return this.title;
        }

        public String getAuthor(){
            return this.author;
        }

        public String getDescription(){
            return this.description;
        }

        public void setTitle(){
            System.out.println("What is the artworks title?");
            this.title = System.console().readLine();
        }
        
        public void setAuthor(){
            System.out.println("Who is the artworks author?");
            this.author = System.console().readLine();
        }

        public void setDescription(){
            System.out.println("Please add a description of the art!");
            this.description = System.console().readLine();
        }
}