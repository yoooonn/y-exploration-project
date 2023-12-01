package top.yooonn.explore.javalib.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author yooonn
 * @date 2022.05.11
 */
public class QrCodeUtils {

    private static final String BASE64_PNG_IMAGE_PREFIX = "data:image/png;base64,";

    public static String getQRCodeImageInBase64(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        BufferedImage image = writeToBufferedImage(bitMatrix);
        ByteArrayOutputStream qrCodePngImageOS = new ByteArrayOutputStream();
        ImageIO.write(image, "png", qrCodePngImageOS);
        String base64EncodedQrCodeImg = Base64.getEncoder().encodeToString(qrCodePngImageOS.toByteArray());
        return BASE64_PNG_IMAGE_PREFIX + base64EncodedQrCodeImg;
    }

    private static BufferedImage writeToBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                image.setRGB(i, j, matrix.get(i, j) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
