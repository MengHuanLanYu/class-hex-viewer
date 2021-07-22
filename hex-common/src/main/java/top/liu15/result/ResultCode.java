package top.liu15.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/7/22 11:13
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(2000, "成功"),
    FAILURE(3000, "失败"),
    FAILURE_SAVE(3001, "添加失败"),
    FAILURE_MODIFY(3002, "修改失败"),
    FAILURE_REMOVE(3003, "删除失败"),
    FAILURE_UPLOAD(3004, "上传失败"),
    FAILURE_PARS(3005, "解析失败"),
    FAILURE_VALID(3006, "校验错误");


    private Integer code;
    private String message;
}
