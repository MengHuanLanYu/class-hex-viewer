package top.liu15.exception;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/3 9:57
 */
public class ParameterException extends RuntimeException {

    public ParameterException() {
        super("参数异常");
    }

    public ParameterException(String message) {
        super(message);
    }
}
