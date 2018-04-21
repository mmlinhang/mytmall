/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package mytmall.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageUtil {


	public static BufferedImage change2jpg(File f) {
		try {
			Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
			PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
			pg.grabPixels();
			int width = pg.getWidth(), height = pg.getHeight();
			final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
			final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
			WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
			return img;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void resizeImage(File srcFile, int width,int height, File destFile) {
		try {
			if(!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			Image i = ImageIO.read(srcFile);
			i = resizeImage(i, width, height);
			ImageIO.write((RenderedImage) i, "jpg", destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage, int width, int height) {
		try {

			BufferedImage buffImg = null;
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			return buffImg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void storeImage(int id, MultipartFile image, File parentDir)
	{
		File file = new File(parentDir, id+".jpg");

		if(!parentDir.exists())
			parentDir.mkdirs();

		try
		{
			image.transferTo(file);
			BufferedImage bi = ImageUtil.change2jpg(file);
			ImageIO.write(bi, "jpg", file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void deleteImage(String parentPath, String imageName)
	{
		File file = new File(parentPath, imageName);
		file.delete();
	}

}

/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
