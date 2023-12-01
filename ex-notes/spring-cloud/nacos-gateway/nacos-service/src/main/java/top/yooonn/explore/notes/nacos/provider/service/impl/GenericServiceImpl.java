package top.yooonn.explore.notes.nacos.provider.service.impl;

import top.yooonn.explore.notes.nacos.provider.service.GenericService;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.stereotype.Service;

/**
 * @author yooonn
 * @date 2021.11.01
 */
@Service
public class GenericServiceImpl implements GenericService {

    @Override
    public Response ping(String message) {
        return Response.success("pong").pin("callback", message);
    }
}
