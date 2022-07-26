package p1;

public class Main {

    public static void main(String[] args) {
        String phrase = "Hello idiot";
        PhraseChecker phraseChecker = new PhraseChecker();
        System.out.println(phraseChecker.validatePhrase(phrase));
    }
}
