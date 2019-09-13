// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import org.slf4j.LoggerFactory;
import java.awt.image.BufferedImage;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.WriterException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;

public class QRcodeUtil
{
    private static final Logger logger;
    
    public static String createQrCode(final String serverUrl, final String qrcodePath, final String address) {
        final int qrcodeColor = -15268848;
        final int qrBackgroundColor = -1;
        final QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(address, BarcodeFormat.QR_CODE, 300, 300);
        }
        catch (WriterException e) {
            QRcodeUtil.logger.error("createQrCode = {}", (Throwable)e);
            return null;
        }
        final MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, qrBackgroundColor);
        final BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
        try {
            ImageIO.write(bufferedImage, "png", new File(qrcodePath + "/" + address + ".png"));
        }
        catch (IOException e2) {
            QRcodeUtil.logger.error("createQrCode = {}", (Throwable)e2);
            return null;
        }
        return serverUrl + "/qrcode/" + address + ".png";
    }
    
    public static String checkQrCode(final String serverUrl, final String qrcodePath, final String address) {
        final File qrcode = new File(qrcodePath + "/" + address + ".png");
        if (!qrcode.isFile()) {
            return createQrCode(serverUrl, qrcodePath, address);
        }
        return "OK";
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)QRcodeUtil.class);
    }
}
