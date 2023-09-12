package Background;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logo
{
	public Logo() throws IOException
	{
		BufferedImage LogoScreen = ImageIO.read(new File("./GameLogo/LogoVaxomon.pmg"));
	}
}