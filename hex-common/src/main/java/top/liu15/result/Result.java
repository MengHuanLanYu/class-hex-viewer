package top.liu15.result;

import lombok.*;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/7/22 11:11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(String message) {
        return new Result(ResultCode.FAILURE.getCode(), message, null);
    }
    
    public static Result failure(ResultCode resultCode) {
        return new Result(resultCode, null);
    }

}
