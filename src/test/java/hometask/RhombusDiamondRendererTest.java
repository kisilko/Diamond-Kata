package hometask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RhombusDiamondConsolediamondRendererTest {

    @Test
    public void it_throws_exception_on_incorrect_input() {
        // given
        char invalidInput = '=';
        RhombusDiamondRenderer diamondRenderer = new RhombusDiamondRenderer();

        // when
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            diamondRenderer.render(invalidInput);
        });

        assertThat(thrown.getMessage()).isEqualTo("Input char can't be smaller that 'A' in ascii table");
    }

    @ParameterizedTest
    @MethodSource("diamondDataProvider")
    public void it_generates_rhombus_diamond_on_valid_input(char input, String expected) {
        // given
        RhombusDiamondRenderer diamondRenderer = new RhombusDiamondRenderer();

        // when
        String diamond = diamondRenderer.render(input);

        // then
        assertThat(diamond).isEqualTo(expected);
    }

    static Stream<Arguments> diamondDataProvider() {
        return Stream.of(
            arguments('A', "A"),
            arguments('B', """
                             A\s
                            B B
                             A\s"""),
            arguments('C', """
                          A \s
                         B B\s
                        C   C
                         B B\s
                          A \s"""),
            arguments('E', """
                            A   \s
                           B B  \s
                          C   C \s
                         D     D\s
                        E       E
                         D     D\s
                          C   C \s
                           B B  \s
                            A   \s""")
        );
    }
}