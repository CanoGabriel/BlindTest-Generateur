import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreator {
	//Ne pas oublier le ".jpg" à la fin du name
	
	public void create(String name, String s){
		Font font = new Font("TimeRoman", Font.PLAIN, 280);
		BufferedImage img = new BufferedImage(1920,1080,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
		g2d.setColor(Color.WHITE);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawString(s,img.getWidth()/2 -g2d.getFontMetrics(font).stringWidth(s)/2,(img.getHeight() /*- g2d.getFontMetrics(font).stringWidth(s)*/)/2);
		g2d.dispose();
		try {
			ImageIO.write(img, "jpg", new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createSize(String name, String s,int width,int height){
		Font font = new Font("TimeRoman", Font.PLAIN, 100);
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
		g2d.setColor(Color.WHITE);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawString(s,img.getWidth()/2 -g2d.getFontMetrics(font).stringWidth(s)/2,(img.getHeight() + g2d.getFontMetrics(font).stringWidth(s))/2);
		g2d.dispose();
		try {
			ImageIO.write(img, "jpg", new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


