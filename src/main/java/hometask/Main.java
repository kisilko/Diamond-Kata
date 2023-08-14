package hometask;

public class Main {
    public static void main(String[] args) {
        char ch = args[0].charAt(0);

        RhombusDiamondRenderer diamondGenerator = new RhombusDiamondRenderer();
        System.out.println(diamondGenerator.render(ch));
    }
}