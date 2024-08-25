package exercise;

public class ReversedSequence implements CharSequence {

    private String string;

    public ReversedSequence(String string) {
        this.string = string;
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= string.length()) {
            throw new StringIndexOutOfBoundsException("Index out of range: " + index);
        }
        char[] chars =  string.toCharArray();
        if (index == 0) {
            return chars[string.length() - 1];
        } else {
            return chars[string.length() - index - 1];
        }
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > string.length() || start > end) {
            throw new StringIndexOutOfBoundsException("Invalid start or end index");
        }
        char[] chars = string.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = end; i >= start + 1; i--) {
            answer.append(chars[i]);
        }
        return answer;
    }

    @Override
    public String toString() {
        char[] chars = string.toCharArray();
        StringBuilder reversedString = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversedString.append(chars[i]);
        }
        return reversedString.toString();
    }
}
