package fighter;

import java.util.*;

public class FighterFactory {
    private final static int HUNDRED = 100;
    private final static double FIFTY = 50.0;
    private final static int ONE = 1;
    private final static String LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    private final static Set<String> IDENTIFIERS = new HashSet<String>();

    public static Fighter getNewFighter() {
        Random random = new Random();
        int s = random.nextInt(HUNDRED) + ONE;
        int d = random.nextInt(HUNDRED) + ONE;
        int i = random.nextInt(HUNDRED) + ONE;
        int sum = s + d + i;
        double coef = FIFTY / sum;

        int strength = (int) (s * coef) == 0 ? 1 : (int) (s * coef);
        int dexterity = (int) (d * coef);
        int intuition = (int) (i * coef);

        return new Fighter(randomIdentifier(), strength, dexterity, intuition);
    }

    public static List<Fighter> getFighterList(int n) {
        List<Fighter> fighterList = new LinkedList<Fighter>();
        for (int i = 0; i < n; i++) {
            fighterList.add(i, FighterFactory.getNewFighter());
        }

        return fighterList;
    }

    private static String randomIdentifier() {
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