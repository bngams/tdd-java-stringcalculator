import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class StringCalculatorTest {

    /**
     * Step 1 - we need to comment on step 4
     */
    /*@Test
    public void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("1,2,3");
        });
    }*/

    /**
     * Step 1
     */
    @Test
    public void when2NumbersAreUsedThenNoExceptionIsThrown() {
        Assertions.assertDoesNotThrow(() -> StringCalculator.add("1,2"));
    }

    /**
     * Step 1
     */
    @Test
    public void whenNonNumberIsUsedThenExceptionIsThrown() {
        // use parseInt to convert string number  to int
        Assertions.assertThrows(NumberFormatException.class, () -> {
            StringCalculator.add("1,X");
        });
    }

    /**
     * Step 2
     */
    @Test
    public void whenNoNumberIsUsedThenReturnValueIs0() {
        Assertions.assertEquals(0, StringCalculator.add(""));
    }

    /**
     * Step 3
     */
    @Test
    public void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assertions.assertEquals(3, StringCalculator.add("3"));
    }

    /**
     * Step 3
     */
    @Test
    public void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assertions.assertEquals(3+6, StringCalculator.add("3,6"));
    }

    /**
     * Step 4
     */
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesSums() {
        Assertions.assertEquals(3+6+12+24, StringCalculator.add("3,6,12,24"));
    }

    /**
     * Step 5
     */
    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesSums() {
        Assertions.assertEquals(3+6+12, StringCalculator.add("3,6\n12"));
    }

    /**
     * Step 6 - we need to comment on step 9, 10
     */
    /*@Test
    public final void whenOtherDelimitersUsedThenReturnValuesSums() {
        Assertions.assertEquals(1+3, StringCalculator.add("//; \n1;3"));
    }*/

    /**
     * Step 7
     */
    @Test
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("3,-6,12,-24");
        });
    }

    /**
     * Step 8
     */
    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000ThenItIsNotIncludedInSum() {
        Assertions.assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6"));
    }

    /**
     * Step 9,10
     */
    @Test
    public final void whenManyDelimitersUsedThenReturnValuesSums() {
        Assertions.assertEquals(1+2+3, StringCalculator.add("// [-] [%] \n1-2% 3"));
    }

}
