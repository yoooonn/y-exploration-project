package top.yooonn.explore.notes.bootweb.advice;

import top.yooonn.explore.notes.bootweb.BootProcessApplication;
import com.ycourlee.tranquil.redisson.WaitLockTimeoutException;
import com.ycourlee.tranquil.web.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yooonn
 * @date 2022.06.24
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger log = LoggerFactory.getLogger(BootProcessApplication.class);

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(WaitLockTimeoutException.class)
    public ApiResponse<Object> handlerWaitLockTimeoutException(WaitLockTimeoutException e) {
        log.warn("wait lock {} timeout", e.getKeys());
        return ApiResponse.error(-1, "操作太快啦");
    }
}
