package fincare.videoKYC.model.saveDetails;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.util.Iterator;

public class ImageCompression {
	
	 private static final String ILLEGAL_COMPRESSION_RATIO = "Illegal compressed image quality (quality must be >= 0 and <= 1)";
	    private static final String NULL_BYTES = "imageBytes cannot be null";
	    private static final String IMAGE_FORMAT = "jpg";
	    private static Base64.Encoder mEncoder = null;
	    private static Base64.Decoder mDecoder = null;

	    public static byte[] compressImage(byte[] imageBytes, float compressedImageQuality)
		{
	        if(imageBytes == null)
			{
	            throw new IllegalArgumentException(NULL_BYTES);
	        }

	        if(!isCompressionRatioValid(compressedImageQuality))
			{
	            throw new IllegalArgumentException(ILLEGAL_COMPRESSION_RATIO);
	        }

	        try(InputStream mInputStream = new ByteArrayInputStream(imageBytes);
	            ByteArrayOutputStream mOutputStream = new ByteArrayOutputStream();
	            ImageOutputStream mImageOutputStream = ImageIO.createImageOutputStream(mOutputStream))
				
			{

	            BufferedImage mBufferedImage = ImageIO.read(mInputStream);

	            Iterator<ImageWriter> mImageWriters = ImageIO.getImageWritersByFormatName(IMAGE_FORMAT);
	            ImageWriter mImageWriter = mImageWriters.next();
	            mImageWriter.setOutput(mImageOutputStream);

	            ImageWriteParam mParam = mImageWriter.getDefaultWriteParam();
	            if(mParam.canWriteCompressed()){
	                mParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	                mParam.setCompressionQuality(compressedImageQuality);
	            }

	            mImageWriter.write(null, new IIOImage(mBufferedImage, null, null), mParam);
	            return mOutputStream.toByteArray();

	        }catch(IOException e)
			{
	            throw new IllegalStateException(e);
	        }
	    }

	    public static String compressImageBase64(byte[] imageBytes, float compressedImageQuality){
	        if(mEncoder == null){
	            mEncoder = Base64.getEncoder();
	        }
	        return mEncoder.encodeToString(compressImage(imageBytes, compressedImageQuality));
	    }

	    public static String compressImageBase64(String imageBase64, float compressedImageQuality){
	        if(mDecoder == null){
	            mDecoder = Base64.getDecoder();
	        }
	        return compressImageBase64(mDecoder.decode(imageBase64), compressedImageQuality);
	    }

	    private static boolean isCompressionRatioValid(float ratio){
	        return ratio >= 0 && ratio <= 1;
	    }

}
