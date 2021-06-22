import java.nio.ByteBuffer;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/22 13:50
 */
public class ByteTest {

    public static void main(String[] args) {
        long number = 262656;
        String s = Long.toUnsignedString(number);
        ByteBuffer wrap = ByteBuffer.wrap(s.getBytes());
        int i = Short.toUnsignedInt(wrap.getShort());
        System.out.println(i);
        System.out.println(s);
    }
}
