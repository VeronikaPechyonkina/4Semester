import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


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

    public static void main(String[] args) throws Exception{

        PGMImage Pic1 = new PGMImage(60,80);

        for (int i = 0; i < Pic1.getHeight(); i++) {
            for (int j = 0; j < Pic1.getWidth(); j++) {
                Pic1.setPixel(i, j, (int) (Math.random()*256));
            }
        }
        Pic1.saveTo("PicRandom.pgm");


        PGMImage Pic2 = new PGMImage(60,80);
        for (int i = 0; i < Pic2.getHeight(); i++)
            for (int j = 0; j < Pic2.getWidth(); j++)
                Pic2.setPixel(i, j, (i + j) % 256);

        Pic2.saveTo("PicGradient.pgm");
    }
}
