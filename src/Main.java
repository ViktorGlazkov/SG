import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder("");
        int n;

        System.out.println("Enter a string amount: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            stringBuilder.append(scanner.next() + " ");
        }

        sortString(stringBuilder, n);
        printStringBuilder(stringBuilder, n);
    }

    private static void sortString(StringBuilder stringBuilder, int stringAmount) {
        boolean wasReplaced;
        Word firstWord;
        Word secondWord;

        do {
            wasReplaced = false;

            for (int i = 0; i < stringAmount - 1; i++) {
                firstWord = getWordFromStringBuilder(stringBuilder, i);
                secondWord = getWordFromStringBuilder(stringBuilder, i + 1);

                if (firstWord.length() < secondWord.length()) {
                    stringBuilder.replace(firstWord.getStartIndex(), secondWord.getEndIndex(),
                            secondWord.getWord() + " " + firstWord.getWord());
                    wasReplaced = true;
                }
            }

        } while (wasReplaced);
    }

    private static Word getWordFromStringBuilder(StringBuilder stringBuilder, int number) {
        int emtyCharAmount = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < stringBuilder.length(); i++) {
            if(emtyCharAmount == number) {
                startIndex = i;
                while (i < stringBuilder.length() && stringBuilder.charAt(i) != ' ') {
                    i++;
                }
                endIndex = i;
                break;
            }
            if(stringBuilder.charAt(i) == ' ') {
                emtyCharAmount++;
            }
        }

        return new Word(startIndex, endIndex, stringBuilder.substring(startIndex, endIndex));
    }

    private static void printStringBuilder(StringBuilder stringBuilder, int stringAmount) {
        for(int i = 0; i < stringAmount; i++) {
            System.out.println(getWordFromStringBuilder(stringBuilder, i).getWord());
        }
    }
}
