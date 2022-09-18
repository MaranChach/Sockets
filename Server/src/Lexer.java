public class Lexer {

    public static int Calculate(String primer){
        int result = 0;

        primer = primer.replace('+', 'p');

        String[] numbers = primer.split("p");
        for (String number : numbers){
            result += Integer.parseInt(number);
        }
        return result;
    }
}
