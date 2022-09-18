public class AlfredTest {

    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testGuestGreeting2 = alfredBot.guestGreeting();
        String testGuestGreeting3 = alfredBot.guestGreeting2("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        String upsetAlfred = alfredBot.dontTemptMe("I think your pastries are not good enough.");
        String upsetAlfred2 = alfredBot.dontTemptMe("I think with the way your prepared dinner, your food is bland and unenjoyable.");
        String upsetAlfred3 = alfredBot.dontTemptMe("Can you hurry faster, i don't have all day.");
        
        System.out.println(testGreeting);
        
        System.out.println(testGuestGreeting);
        System.out.println(testGuestGreeting2);
        System.out.println(testGuestGreeting3);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(upsetAlfred);
        System.out.println(upsetAlfred2);
        System.out.println(upsetAlfred3);
    }
}
