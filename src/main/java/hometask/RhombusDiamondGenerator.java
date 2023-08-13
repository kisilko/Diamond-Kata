package hometask;

public class RhombusDiamondGenerator {
    private int rhombusHeight;
    private String blankRow;

    public String generate(char ch) {
        sanitiseInput(ch);
        calculateOutputCanvasSize(ch);
        return generateRhombus(0);
    }

    private String generateRhombus(int level) {
        String output;
        if (level == rhombusHeight / 2) {
            output = generateRhombusCenter(getCharFor(level));
        } else {
            String scanline = (level == 0) ? generateTopVertex() : generateLine(level);

            output = scanline + "\n";
            output += generateRhombus(level + 1);
            output += scanline;
        }
        if (level > 0) {
            output += "\n";
        }
        return output;
    }

    private void sanitiseInput(char inputChar) {
        if (inputChar < 'A') {
            throw new IllegalArgumentException("Input char can't be smaller that 'A' in ascii table");
        }
    }

    private void calculateOutputCanvasSize(char inputChar) {
        rhombusHeight = (inputChar - 'A') * 2 + 1;
        blankRow = " ".repeat(rhombusHeight);
    }

    private String generateRhombusCenter(char ch) {
        return CharUtils.setCharacterAt(blankRow, ch, 0, rhombusHeight - 1);
    }

    private String generateLine(int level) {
        int mid = (int) Math.ceil(rhombusHeight / 2);
        int centralDistance = mid - level;

        return CharUtils.setCharacterAt(
            blankRow,
            getCharFor(level),
            centralDistance, rhombusHeight - centralDistance - 1
        );
    }

    private char getCharFor(int level) {
        return (char) ('A' + level);
    }

    private String generateTopVertex() {
        int mid = rhombusHeight / 2;
        return CharUtils.setCharacterAt(blankRow, 'A', mid);
    }
}
