package chapter01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 나의 첫번쨰 버전
    public int myAdd(String text){
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens ;

        if (m.find()){
            String customDelimeter = m.group(1);
            tokens = m.group(2).split(customDelimeter);
        } else{
            tokens = text.split(",|:");
        }

        int answer = 0;
        for (String token : tokens){
            int number = Integer.parseInt(token);
            if (number < 0){
                throw new RuntimeException("음수 입니다.");
            }
            answer += number;
        }

        return answer;
    }

    // 책
    public int add (String text){
        if (isBlank(text)){
            return 0;
        }

        String[] values = text.split(",|:");
        return sum(toInts(values));
    }

    public String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()){
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }

    private boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for (int i = 0 ; i < values.length; i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    public int toPositive(String value){
        int number = Integer.parseInt(value);
        if (number < 0){
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers){
        int sum = 0;
        for (int number : numbers){
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args){
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add("1,2"));
    }

}
