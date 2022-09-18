import java.util.*;

class Hashmatique{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Rager", "... this party has destroyed the block...");
        trackList.put("All night", "...Been up from sun to sun...");
        trackList.put("Get groovy", "... Loosen up with whats in your cup, get groovy...");
        trackList.put("Wrong way", "... and It feels like I am going the wrong way...");

        System.out.println("Rager: " + trackList.get("Rager"));

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + trackList.get(key));

        }
    }
}