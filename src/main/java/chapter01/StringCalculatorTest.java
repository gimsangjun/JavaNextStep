package chapter01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeEach
    public void setup(){
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자(){
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나(){
        assertEquals(1, cal.add("1"));
    }

    @Test
    public void add_쉼표구분자(){
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() throws Exception{
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test
    public void add_음수더하기() throws Exception{
        assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }

    // String의 split메소드에 숫자 하나를 가지는 문자열을 전달하면 숫자 하나가 담겨 있는 String[]을 반환하면 코드를 더 줄일수 있다.
    @Test
    public void split(){
        assertArrayEquals(new String[] {"1"}, "1".split(","));
        assertArrayEquals(new String[] {"1", "2"}, "1,2".split(","));
    }
}
