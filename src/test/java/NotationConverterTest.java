import org.junit.Test;

import static org.junit.Assert.*;

public class NotationConverterTest {
    private final NotationConverter converter = new NotationConverter();

    @Test
    public void shouldReturn3() {
        final int result = converter.toArabic("III");
        assertEquals(3, result);
    }

    @Test
    public void shouldReturn12() {
        final int result = converter.toArabic("XII");
        assertEquals(12, result);
    }

    @Test
    public void shouldReturn59() {
        final int result = converter.toArabic("LIX");
        assertEquals(59, result);
    }

    @Test
    public void shouldReturn1990() {
        final int result = converter.toArabic("MCMXC");
        assertEquals(1990, result);
    }

    @Test(expected = InvalidValueException.class)
    public void stringWithNotRomanNumeralsShouldThrowException() {
        converter.toArabic("1");
    }

    @Test(expected = InvalidValueException.class)
    public void romanAndNotRomanNumeralsShouldThrowException() {
        converter.toArabic("VI1");
    }

    @Test(expected = InvalidValueException.class)
    public void emptyStringShouldThrowException() {
        converter.toArabic("");
    }

    @Test(expected = InvalidValueException.class)
    public void nullShouldThrowException() {
        converter.toArabic(null);
    }
}
