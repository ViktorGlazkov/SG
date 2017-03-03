package fighter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NameFactory {
    private final static String LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    private final static Set<String> IDENTIFIERS = new HashSet<String>();

    public static String randomIdentifier() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        while(builder.toString().length() == 0) {
            int length = random.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(LEXICON.charAt(random.nextInt(LEXICON.length())));
            }
            if(IDENTIFIERS.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}
