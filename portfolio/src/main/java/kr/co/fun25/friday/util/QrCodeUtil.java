package kr.co.fun25.friday.util;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Component("QrCodeUtil")
public class QrCodeUtil {

	public 	BitMatrix makeQRMatrix(String url, int width, int height){
		QRCodeWriter  qrCodeWriter = new QRCodeWriter();
		
		BitMatrix matrix = null;
		MatrixToImageConfig config = null;
		//BufferedImage  qrImage = null;
		try {
			url = new String(url.getBytes("UTF-8"), "ISO-8859-1");
			
			matrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, width, height);
					
			//qr code color
			//config = new MatrixToImageConfig(qrColor, backColor);
			
			//save file
			//qrImage = MatrixToImageWriter.toBufferedImage(matrix,config);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}
		
		return matrix;
	}

	public MatrixToImageConfig makeColorConfig(String qrColor, String backColor){
				
		int intQrColor = 0;
		int intBackColor = 0;
		
		try{
			intQrColor = Integer.parseUnsignedInt(qrColor,16);			
		}catch(Exception e){
			intQrColor = 0xff000000;			
		}
		
		try{
			intBackColor = Integer.parseUnsignedInt(backColor,16);	
		}catch(Exception e){
			intBackColor = 0xffffffff;
		}
		
		
		return new MatrixToImageConfig(intQrColor, intBackColor);		
	}
}
