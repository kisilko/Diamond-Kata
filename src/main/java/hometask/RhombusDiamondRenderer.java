package hometask;

public class RhombusDiamondRenderer {
    private int canvasHeight;
    private String blankLine;

    public String render(char ch) {
        sanitiseInput(ch);
        calculateOutputCanvasSize(ch);
        return renderRhombus(ch);
    }

    private String renderRhombus(char ch) {
        if (isSingleElementRhombus(ch)) {
            return renderTopVertex();
        } else {
            String rhombusTop = renderRhombusTopBlock();
            String rhombusCenter = renderRhombusCenterLine(ch);
            String rhombusBottom = CharUtils.reverse(rhombusTop);

            return rhombusTop + "\n"
                 + rhombusCenter + "\n"
                 + rhombusBottom;
        }
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

    private boolean isSingleElementRhombus(char ch) {
        return ch == 'A';
    }

    private String renderRhombusCenterLine(char ch) {
        return renderLine(canvasHeight / 2);
    }

    private String renderRhombusTopBlock() {
        String topVertex = renderTopVertex();
        StringBuilder output = new StringBuilder(topVertex);
        for (int i = 1; i < canvasHeight / 2; i++) {
            output.append("\n").append(renderLine(i));
        }
        return output.toString();
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
