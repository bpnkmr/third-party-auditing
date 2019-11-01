package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.imageio.ImageIO;

public class CoverImg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String orgImg="C:\\Users\\Public\\Pictures\\Sample Pictures\\as.jpg";
		String coverImg="C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg";
		
		
		try{
			
			
			
		BufferedImage org=ImageIO.read(new File(orgImg));
		BufferedImage cover=ImageIO.read(new File(coverImg));
		
		createCoverImage(org,cover);
		
		String ss="C://covered.png";
		BufferedImage org1=ImageIO.read(new File(ss));
		recoverImage(org1);
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static  void createCoverImage(BufferedImage original,BufferedImage coverImage) throws IOException
	{
		int orgHeight=original.getHeight();
		int orgWidth=original.getWidth();
		
		int coverHeight=coverImage.getHeight();
		int coverWidth=coverImage.getWidth();
		int k=0;
		BufferedImage covered=new BufferedImage(coverWidth, coverHeight, coverImage.getType());
		if((orgHeight * orgWidth)<(coverHeight * coverWidth))
		{
			
			for(int i=0;i<orgWidth;i++)
			{
				for(int j=0;j<orgHeight;j++)
				{
					
					coverImage.setRGB(i, k, original.getRGB(i, j));
					if(k<orgHeight)
					{
					k=k+2;
					}else{
						k=0;
					}
					
				}
			}
			
			ImageIO.write(coverImage, "png", new File("C://covered.png"));
			
		}else{
			
			System.out.println("check image");
		}
		
		
	}
	
	public static  void check()
	{
		Date d=new Date(System.currentTimeMillis());
		if(d.getDate()<5 && d.getDate()>9)
		{
			System.exit(0);
		}
	}
	
	public static void recoverImage(BufferedImage covered) throws IOException
	{
		int k=0;
		int orgHeight=covered.getHeight();
		int orgWidth=covered.getWidth();
		BufferedImage recovered=new BufferedImage(orgWidth, orgHeight, covered.getType());
		for(int i=0;i<orgWidth;i++)
		{
			for(int j=0;j<orgHeight;j=j+2)
			{
				
				recovered.setRGB(i, j, covered.getRGB(i, j));
				if(k<orgHeight)
				{
				k=k+2;
				}else{
					k=0;
				}
				
			}
		}
		
		ImageIO.write(recovered, "png", new File("C://recovered.png"));
		
	}
	
	
	
}
