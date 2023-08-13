package hometask;

public class Main {
    public static void main(String[] args) {
        char ch = args[0].charAt(0);

        RhombusDiamondGenerator diamondGenerator = new RhombusDiamondGenerator();
        System.out.println(diamondGenerator.generate(ch));
    }
}