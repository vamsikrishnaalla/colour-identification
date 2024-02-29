package ideathon.uk.imageprocessing.process;

import ideathon.uk.imageprocessing.colors.ColorUtils;
import ideathon.uk.imageprocessing.colors.ColourArea;
import ideathon.uk.imageprocessing.colors.ColourReader;
import ideathon.uk.imageprocessing.colors.Hue;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ImageProcessor {
    public void generateColorsFromImage() throws IOException {
        BufferedImage img = ImageIO.read(new File("input/image.png"));
        List<ColourArea> areas = new ColourReader()
                .withResolution(0.9f)              // sample only 50% of the image pixels
                .withBlackThreshold(0.5f)          // consider pixels with brightness less than this to be black
                .withWhiteThreshold(0.5f)          // consider pixels with brightness greater than 1 minus this to be white
                .withHues(Arrays.asList(Hue.BASE)) // use BASE hues set
                .colourArea(img);

        List<Color> colors = areas.stream().map(a -> Color.HSBtoRGB(a.colour().hue(),
                        a.colour().saturation(),
                        a.colour().brightness()))
                .map(Color::new).toList();
        ColorUtils colorUtils = new ColorUtils();
        System.out.println("Output:");
        System.out.println("-----------------------------------------------------");
        for (Color color : colors) {
            System.out.println(colorUtils.getColorNameFromColor(color)+"=> RGB value:" + color);
        }
        int imgHeight = 1000;
        int imgWidth = 1000;

        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();  // not sure on this line, but this seems more right
        int size = colors.size();
        int blockSize = imgWidth/size;
        int xStart =0;
        int xEnd = blockSize;
        int i =1;
        for (Color color : colors) {
            g.setColor(color);
            g.fillRect(xStart,0,xEnd,imgHeight);
            ++i;
            xStart = (i-1) * blockSize;
            xEnd = i * blockSize;
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Color palettes identified and output image can be found at output folder");

        File outputFile = new File("output/output.png");
        ImageIO.write(image, "png", outputFile);

    }
}
