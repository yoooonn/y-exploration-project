package com.ycourlee.explore.notes.nacos.provider.wrapper;

import lombok.Getter;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author yooonn
 * @date 2021.09.11
 */
public class BodySerialHttpServletRequestWrapper extends HttpServletRequestWrapper {

    @Getter
    private final String bodyString;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request request.
     * @throws IllegalArgumentException if the request is null
     */
    public BodySerialHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        ServletInputStream inputStream = request.getInputStream();
        bodyString = new String(StreamUtils.copyToByteArray(inputStream), StandardCharsets.UTF_8);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bodyString.getBytes(StandardCharsets.UTF_8));

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {}

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}
