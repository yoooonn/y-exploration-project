package com.ycourlee.explore.notes.cloud.aio.configuration.logging;

import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author yooonn
 * @date 2023.01.28
 */
public class PersistableJsonBodyHttpServletRequest extends HttpServletRequestWrapper {

    private final byte[] jsonBody;

    public PersistableJsonBodyHttpServletRequest(HttpServletRequest request) {
        super(request);
        if (!isJsonContentType(request.getContentType())) {
            throw new UnsupportedOperationException("Request must be compatible with application/json");
        }
        try {
            jsonBody = StreamUtils.copyToByteArray(request.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getJsonBody() {
        return StringUtils.trimAllWhitespace(new String(jsonBody, Charset.forName(getCharacterEncoding())));
    }

    @Override
    public ServletInputStream getInputStream() {

        return new ServletInputStream() {

            private final ByteArrayInputStream delegate = new ByteArrayInputStream(jsonBody);

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return this.delegate.read();
            }

            @Override
            public int readLine(byte[] b, int off, int len) throws IOException {
                return super.readLine(b, off, len);
            }

            @Override
            public int read(byte[] b) throws IOException {
                return this.delegate.read(b);
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                return this.delegate.read(b, off, len);
            }

            @Override
            public long skip(long n) throws IOException {
                return this.delegate.skip(n);
            }

            @Override
            public int available() throws IOException {
                return this.delegate.available();
            }

            @Override
            public void close() throws IOException {
                this.delegate.close();
            }

            @Override
            public synchronized void mark(int readlimit) {
                this.delegate.mark(readlimit);
            }

            @Override
            public synchronized void reset() {
                this.delegate.reset();
            }

            @Override
            public boolean markSupported() {
                return this.delegate.markSupported();
            }
        };
    }

    public static boolean isJsonContentType(String contentType) {
        if (StringUtils.isEmpty(contentType)) {
            return false;
        }
        return MimeTypeUtils.APPLICATION_JSON.isCompatibleWith(MimeTypeUtils.parseMimeType(contentType.split(";")[0].trim()));
    }
}
