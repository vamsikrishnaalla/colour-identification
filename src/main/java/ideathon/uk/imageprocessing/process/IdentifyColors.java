package ideathon.uk.imageprocessing.process;

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

public class IdentifyColors {
    public List<Color> getColorsListInImage(String imagePath) {
        BufferedImage img;
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        java.util.List<ColourArea> areas = new ColourReader()
                .withResolution(0.9f)              // sample only 50% of the image pixels
                .withBlackThreshold(0.5f)          // consider pixels with brightness less than this to be black
                .withWhiteThreshold(0.5f)          // consider pixels with brightness greater than 1 minus this to be white
                .withHues(Arrays.asList(Hue.BASE)) // use BASE hues set
                .colourArea(img);

        return areas.stream().map(a -> Color.HSBtoRGB(a.colour().hue(),
                        a.colour().saturation(),
                        a.colour().brightness()))
                .map(Color::new).toList();
    }
}
