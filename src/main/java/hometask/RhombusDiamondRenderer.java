package hometask;

public class RhombusDiamondRenderer {
    private int canvasHeight;
    private String blankLine;

    public String render(char ch) {
        sanitiseInput(ch);
        calculateOutputCanvasSize(ch);
        return renderRhombus(0);
    }

    private String renderRhombus(int level) {
        String output;
        if (level == canvasHeight / 2) {
            output = renderRhombusCenterLine(getCharFor(level));
        } else {
            String scanline = (level == 0) ? renderTopVertex() : renderLine(level);

            output = scanline + "\n";
            output += renderRhombus(level + 1);
            output += scanline;
        }
        if (level > 0) {
            output += "\n";
        }
        return output;
    }

    private void sanitiseInput(char ch) {
        if (ch < 'A') {
            throw new IllegalArgumentException("Input char can't be smaller that 'A' in ascii table");
        }
    }

    private void calculateOutputCanvasSize(char ch) {
        canvasHeight = (ch - 'A') * 2 + 1;
        blankLine = " ".repeat(canvasHeight);
    }


    private String renderRhombusCenterLine(char ch) {
        return renderLine(canvasHeight / 2);
    }


    private String renderLine(int level) {
        int mid = (int) Math.ceil(canvasHeight / 2);
        int centralDistance = mid - level;

        return CharUtils.setCharacterAt(
            blankLine,
            getCharFor(level),
            centralDistance, canvasHeight - centralDistance - 1
        );
    }

    private char getCharFor(int level) {
        return (char) ('A' + level);
    }

    private String renderTopVertex() {
        int mid = canvasHeight / 2;
        return CharUtils.setCharacterAt(blankLine, 'A', mid);
    }
}
