import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;

class PGMImage {
    private int[][] colors;

    public PGMImage(int height, int width){
        int[][] colors = new int[height][width];
    }

    public void setPixel(int x, int y, int color){
        this.colors[x][y] = color;
    }

    public int getWidth() {
        return this.colors.length;
    }

    public int getHeight() {
        return this.colors[0].length;
    }

    public void saveTo(String filename) throws Exception{


        PrintStream image = new PrintStream(filename, StandardCharsets.UTF_8);
        image.println("P2");
        image.println(this.getHeight());
        image.println(this.getWidth());
        image.println("255");

        for (int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                image.print(this.colors[x][y] + " ");
            }
            image.println();
        }
    }
}

public class Task1 {

    public static void main(String[] args){
        PGMImage Pic1 = new PGMImage(60,80){};
        PGMImage Pic2 = new PGMImage(60,80){};
    }
}
