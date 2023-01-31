package com.ycourlee.explore.notes.cloud.aio.configuration.logging;

import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author yooonn
 * @date 2023.01.28
 */
public class PersistableJsonBodyHttpServletResponse extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream baos;
    private final ServletOutputStream   sos;
    private final PrintWriter           pw;

    public PersistableJsonBodyHttpServletResponse(HttpServletResponse response) {
        super(response);
        baos = new ByteArrayOutputStream();
        sos = new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener listener) {
            }

            @Override
            public void write(int b) throws IOException {
                baos.write(b);
            }
        };
        pw = new PrintWriter(new OutputStreamWriter(baos));
    }

    public String getJsonBody() throws IOException {
        if (!isJsonContentType(getContentType())) {
            throw new UnsupportedOperationException("Request must be compatible with application/json");
        }
        flushBuffer();
        String body = baos.toString();
        getResponse().resetBuffer();
        ServletOutputStream superOs = getResponse().getOutputStream();
        superOs.print(body);
        return body;
    }

    @Override
    public void reset() {
        baos.reset();
    }

    public static boolean isJsonContentType(String contentType) {
        if (StringUtils.isEmpty(contentType)) {
            return false;
        }
        return MimeTypeUtils.APPLICATION_JSON.isCompatibleWith(MimeTypeUtils.parseMimeType(contentType.split(";")[0].trim()));
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return sos;
    }

    @Override
    public void flushBuffer() throws IOException {
        baos.flush();
        sos.flush();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;
    }
}
