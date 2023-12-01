package top.yooonn.explore.notes.cloud.aio.watchpoint;

import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yooonn
 * @date 2021.11.30
 */
@Component
@RequiredArgsConstructor
public class ChainDelegator implements WatchPointChain {

    private final List<WatchPoint> watchPoints;

    @Override
    public void doExecute(Response resp, Context context) {
        new DefaultWatchPointChain(watchPoints).doExecute(resp, context);
    }
}
