package top.liu15.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.liu15.result.Result;
import top.liu15.result.ResultCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author lhy
 * @version 1.0
 * @date 2021/7/22 11:07
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    /**
     * 异常校验
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result exceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            List<String> errorList = new ArrayList<>(errors.size());
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                log.warn("Bad Request Parameters: dto entity [{}],field [{}],message [{}]", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                errorList.add(new StringBuilder().append(fieldError.getDefaultMessage()).append("[").append(fieldError.getField()).append("]").toString());
            });
            return Result.failure(errorList.parallelStream().collect(Collectors.joining(",")));
        }
        return Result.failure(ResultCode.FAILURE_VALID);
    }


    @ExceptionHandler(BindException.class)
    public Result exceptionHandler(BindException bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> errorList = new ArrayList<>(fieldErrors.size());
            for (FieldError error : fieldErrors) {
                StringBuilder errorBuilder = new StringBuilder();
                errorBuilder.append(error.getDefaultMessage()).append("[").append(error.getField()).append("]");
                errorList.add(errorBuilder.toString());
            }
            return Result.failure(errorList.parallelStream().collect(Collectors.joining(",")));
        }
        return Result.failure(ResultCode.FAILURE_VALID);
    }

    /**
     * 异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        if (log.isDebugEnabled()){
            e.printStackTrace();
        }
        String error = e.getMessage();
        log.error("其他异常 ===> {}", error);
        return Result.failure(error);
    }
}
