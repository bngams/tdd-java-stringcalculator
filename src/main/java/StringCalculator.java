import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String numbers) {
        // check string full empty (blank => no whitespace) // " "
        if(numbers.isBlank()){
            return 0;
        }
        String delimiter = ",|\\R";
        if (numbers.startsWith("//")) {
            int delimiterStart = numbers.indexOf("//");
            int delimiterEnd = numbers.indexOf("\n");
            String delimiters = numbers.substring(delimiterStart+2, delimiterStart+delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);
            Matcher m = Pattern.compile("\\[([^]]+)\\]")
                    .matcher(delimiters);
            // my delimiters ,|\\R  | + %|-
            delimiter += "|" + m.results().map(MatchResult::group).collect(Collectors.joining("|"));
        }

        // var infers Map<Boolean, List<Integer>> - JAVA 10
        // parseInt can trigger the NumberFormatException directly
        // exception management https://javadevcentral.com/throw-checked-exceptions-in-java-streams
        var allIntegers = Arrays.stream(numbers.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(x -> x <= 1000)
                .peek(StringCalculator::negativeNotAllowed)
                .collect(Collectors.partitioningBy(x -> x > 0));
                // to directly count on downstream
                //.collect(Collectors.partitioningBy(x -> x > 0, Collectors.counting()));

        if(!allIntegers.get(false).isEmpty())
            throw new RuntimeException("Negatives are not allowed: " + allIntegers.get(0).toString());

        return allIntegers.get(true).stream().collect(Collectors.summingInt(Integer::intValue));
        // other return statement
        // return allIntegers.get(true).stream().mapToInt(Integer::intValue).sum();
    }

    static void negativeNotAllowed(Integer n) throws RuntimeException{
        if(n < 0 ) {
            throw new RuntimeException("Negatives are not allowed: " + n.toString());
        }
    }

}
