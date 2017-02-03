
public class Word {
    private int startIndex;
    private int endIndex;
    private String word;

    public Word(int startIndex, int endIndex, String word) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.word = word;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getWord() {
        return word;
    }

    public int length() {
        return word.length();
    }
}
