package ideathon.uk.imageprocessing.process;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateImage {
    public void createImageWithColors(List<Color> colorList, int width, int height, String outputFileName){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();  // not sure on this line, but this seems more right
        int size = colorList.size();
        int blockSize = width/size;
        int xStart =0;
        int xEnd = blockSize;
        int i =1;
        for (Color color : colorList) {
            g.setColor(color);
            g.fillRect(xStart,0,xEnd,height);
            ++i;
            xStart = (i-1) * blockSize;
            xEnd = i * blockSize;
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Color palettes identified and output image can be found at output folder");

        File outputFile = new File(outputFileName);
        try {
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
