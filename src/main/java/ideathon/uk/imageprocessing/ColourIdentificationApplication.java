package ideathon.uk.imageprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColourIdentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColourIdentificationApplication.class, args);
//		List<Color> colorList = new IdentifyColors().getColorsListInImage("input/image.png");
//		new CreateImage().createImageWithColors(colorList,1000,1000,"output/output.png");
	}
}
