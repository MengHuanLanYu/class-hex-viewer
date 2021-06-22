package top.liu15.exception;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/6/10 9:30
 */
public class ByteCodeParsingException extends RuntimeException {
    public ByteCodeParsingException() {
        this("Parsing exception. this file is not a java bytecode file.");
    }

    public ByteCodeParsingException(String message) {
        super(message);
    }
}
