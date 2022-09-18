import java.util.*;
import java.text.*;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String guestGreeting() {
        Date dateTime = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat ( "H" );
        String dateFormat = formatDate.format(dateTime);
        int hourOfDay = Integer.parseInt(dateFormat);
        String dayPeriod;
        if (hourOfDay > 3 && hourOfDay < 12){
            dayPeriod = "Morning";
        } else if (hourOfDay > 11 && hourOfDay < 9){
            dayPeriod = "Afternoon";
        } else {
            dayPeriod = "Evening";
        }
        return String.format("Good %s. Lovely to see you.", dayPeriod);
    }

    public String guestGreeting2(String name){
        Date dateTime = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat ( "H" );
        String dateFormat = formatDate.format(dateTime);
        int hourOfDay = Integer.parseInt(dateFormat);
        String dayPeriod;
        if (hourOfDay > 3 && hourOfDay < 12){
            dayPeriod = "Morning";
        } else if (hourOfDay > 11 && hourOfDay < 9){
            dayPeriod = "Afternoon";
        } else {
            dayPeriod = "Evening";
        }
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date newDate = new Date();
        String strDate = newDate.toString();
        return String.format("It is currently %s.", strDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if ( conversation.indexOf("Alexis") >= 0 ){
            return "Right away, sir. She  certainly isn't sophisticated enough for that.";
        }
        else if ( conversation.indexOf("Alfred") >= 0 ){
            return "At you service. As you wish, naturally.";
        }
        else{
            return "Right, And with that I shall retire.";
            }
        
    }
    
    public String dontTemptMe(String conversation){
        if (conversation.indexOf("not good enough") >= 0){
            return "Not good enough? Well if you think such, then YOU MIGHT AS WELL DO IT YOURSELF!";
        } else if (conversation.indexOf("your food is bland") >= 0 ){
            return "I have been among far more cultures and have experienced far more cuisine. I apollogize that your ELEMENTARY sense of taste is INSULTED BY A LACK OF COPIOUS AMOUNTS OF SALT AND SUGAR.";
        } else if (conversation.indexOf("hurry faster") >= 0){
            return "If you dare rush perfection, I can show you the TRUE MEANING OF PAIN!";
        }
        return "It is a great day when respect flourishes.";
    }
}

