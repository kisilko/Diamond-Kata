package hometask;

public class RhombusDiamondGenerator {
    private int rhombusHeight;
    private String blankRow;

    public String generate(char ch) {
        sanitiseInput(ch);
        calculateOutputCanvasSize(ch);
        return generateRhombus(ch);
    }

    private String generateRhombus(char ch) {
        if (ch == 'A') {
            return generateTopVertex();
        } else {
            String rhombusTop = generateRhombusTop(ch);
            String rhombusCenter = generateRhombusCenter(ch);
            String rhombusBottom = CharUtils.reverse(rhombusTop);

            return rhombusTop + "\n"
                 + rhombusCenter + "\n"
                 + rhombusBottom;
        }
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

    private String generateRhombusTop(char toChar) {
        String topVertex = generateTopVertex();
        StringBuilder output = new StringBuilder(topVertex);
        for (int i = 1; i < rhombusHeight / 2; i++) {
            output.append("\n").append(generateLine(i));
        }
        return output.toString();
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
