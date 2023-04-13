package com.coh.exception;

import com.coh.controller.Code;
import com.coh.controller.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//这是异常处理器
public class MyException {
    /**
     * 处理系统异常
     * @param ex 系统异常类
     * @return Result
     */
    @ExceptionHandler(SystemException.class)
    public Result DoSystemException(SystemException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    /**
     * 处理业务异常
     * @param ex 业务异常类
     * @return Result
     */
    @ExceptionHandler(BusinessException.class)
    public Result DoSystemException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    /**'
     *  任何其他异常，不可预期的
     * @return Result
     */
    @ExceptionHandler(Exception.class)//处理异常的种类
    public Result DoException(){
        System.out.println("MyException.DoException");
        return new Result(Code.SYSTEM_UNKNOWN_ERR,null,"unknown exception,万万没想到啊");
    }
}
