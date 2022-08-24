package my.fast.admin.framework.exception;

import lombok.extern.slf4j.Slf4j;
import my.fast.admin.framework.utils.R;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @Author: ChenQingSong
 * @Date: 2018/6/6 16:57
 * @Description:
 * 异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleMyException(HttpServletRequest req, Exception me) {
        log.error("###Exception###,Url:{}, Msg:{}" ,req.getRequestURI(), me.getMessage());
        String msg = "Operation failed, program internal error!";
        if(me instanceof MyException){
            msg = me.getMessage();
            return R.error(500, msg);
        }else if(me instanceof DataAccessException){
            msg = "Database operation failed!";
        }else if(me instanceof NullPointerException){
            msg = "Uninitialized object called or nonexistent object!";
        }else if(me instanceof IOException){
            msg = "IO exception!";
        }else if(me instanceof ClassNotFoundException){
            msg = "The specified class does not exist!";
        }else if(me instanceof ArithmeticException){
            msg = "Mathematical operation exception!";
        }else if(me instanceof ArrayIndexOutOfBoundsException){
            msg = "subscript out of bounds!";
        }else if(me instanceof NoSuchMethodException){
            msg = "Method not found!";
        }else if(me instanceof IllegalArgumentException){
            msg = "Wrong parameter for method!";
        }else if(me instanceof IllegalAccessException){
            msg = "Illegal access error!";
        }else if(me instanceof InvocationTargetException){
            msg = "Exception in target call!";
        }else if(me instanceof ClassCastException){
            msg = "Type cast error!";
        }else if(me instanceof SecurityException){
            msg = "Abnormal violation of safety principle!";
        }else if(me instanceof SQLException){
            msg = "Operation database exception!";
        }
        return R.error(500, msg, me.getMessage());
    }
}
