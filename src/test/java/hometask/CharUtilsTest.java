package hometask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CharUtilsTest {

    @ParameterizedTest
    @MethodSource("singleIndexDataProvider")
    public void it_insert_char_into_string_with_correct_index(String str, char ch, int index, String expected) {
        // when
        String insertionResult = CharUtils.setCharacterAt(str, ch, index);

        // then
        assertThat(insertionResult).isEqualTo(expected);
    }

    static Stream<Arguments> singleIndexDataProvider() {
        return Stream.of(
            arguments("     ", 'A', 0, "A    "),
            arguments("     ", 'A', 2, "  A  "),
            arguments(" ", 'A', 0, "A")
        );
    }

    @ParameterizedTest
    @MethodSource("multipleIndexDataProvider")
    public void it_insert_char_into_string_with_correct_indexes(String str, char ch, int[] index, String expected) {
        // when
        String insertionResult = CharUtils.setCharacterAt(str, ch, index);

        // then
        assertThat(insertionResult).isEqualTo(expected);
    }

    static Stream<Arguments> multipleIndexDataProvider() {
        return Stream.of(
            arguments("     ", 'A', new int[] {0, 4}, "A   A"),
            arguments("     ", 'A', new int[] {0, 2, 4}, "A A A"),
            arguments("   ", 'A', new int[] {0, 1, 2}, "AAA")
        );
    }

    @Test
    public void it_throws_exception_when_index_out_of_bounds() {
        // given
        String dummyString = "short";
        char ch = 'A';
        int tooBigIndex = 9;

        // when
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            String insertionResult = CharUtils.setCharacterAt(dummyString, ch, tooBigIndex);
        });

        // then
        assertThat(thrown).isNotNull();
    }


    @Test
    public void it_reverses_strings() {
        // given
        String genericString = "12gka12";

        // when
        String reversed = CharUtils.reverse(genericString);

        // then
        assertThat(reversed).isEqualTo("21akg21");
    }
}