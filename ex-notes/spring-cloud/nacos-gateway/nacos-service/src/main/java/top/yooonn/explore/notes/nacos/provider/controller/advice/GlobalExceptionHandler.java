package top.yooonn.explore.notes.nacos.provider.controller.advice;

import com.ycourlee.tranquil.redisson.WaitLockTimeoutException;
import com.ycourlee.tranquil.web.ApiCode;
import com.ycourlee.tranquil.web.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yooonn
 * @date 2022.04.29
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = WaitLockTimeoutException.class)
    public ApiResponse<Object> waitLockTimeoutException(HttpServletRequest request, WaitLockTimeoutException e) {
        log.warn("uri: {}, message: {}", request.getRequestURI(), e.getMessage(), e);
        return ApiResponse.error(-1, "您访问太快啦～");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public ApiResponse<Object> exception(HttpServletRequest request, Exception e) {
        log.error("uri: {}, message: {}", request.getRequestURI(), e.getMessage(), e);
        return ApiResponse.error(ApiCode.ERROR);
    }
}
