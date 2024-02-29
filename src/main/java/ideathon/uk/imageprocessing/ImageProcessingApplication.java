package ideathon.uk.imageprocessing;

import ideathon.uk.imageprocessing.process.CreateImage;
import ideathon.uk.imageprocessing.process.IdentifyColors;
import ideathon.uk.imageprocessing.process.ImageProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ImageProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageProcessingApplication.class, args);
//		List<Color> colorList = new IdentifyColors().getColorsListInImage("input/image.png");
//		new CreateImage().createImageWithColors(colorList,1000,1000,"output/output.png");
	}
}
