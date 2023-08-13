package hometask;

public class CharUtils {

    public static String setCharacterAt(String str, char ch, int ...index) {
        StringBuilder sb = new StringBuilder(str);
        for (int i : index) {
            sb.setCharAt(i, ch);
        }
        return sb.toString();
    }

    public static String reverse(String str) {
        StringBuilder string = new StringBuilder(str);
        string.reverse();
        return string.toString();
    }
}
