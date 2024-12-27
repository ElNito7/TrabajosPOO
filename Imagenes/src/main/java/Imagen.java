
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keloc
 */
public class Imagen {
    public static void main(String[] args) throws IOException {
        int width = 201;
        int height = 251;
        BufferedImage img = null;
        img = readFromFile(width, height, img);
        writeToFile(img);
    }
    
    public static BufferedImage readFromFile(int width, int height, BufferedImage image){
        try {
            File sample = new File("C:\\Users\\Keloc\\Desktop\\imagen.jpg");
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(sample);
        } catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return image;
    }
    
    public static void writeToFile(BufferedImage img){
        try {
            File output = new File("src\\main\\java\\output.jpg");
            ImageIO.write(img, "jpg", output);
            System.out.println("Si pudo");
        } catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
