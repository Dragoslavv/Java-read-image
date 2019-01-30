import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Test {

    static final File dir = new File("/home/dragoslav/IdeaProjects/Test/src");

    static final String[] EXTENSIONS = new String[]{
            "gif", "png", "bmp", "jpg"
    };

    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

//        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return true;
                }
            }
            return false;
        }
    };

    public static void main(String[] args) {

        if (dir.isDirectory()) {
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);

                    System.out.println(" image:  " +  f.getName() );
                    System.out.println(" width : " +  img.getWidth() );
                    System.out.println(" height: " +  img.getHeight() );
                    System.out.println(" size  : " +  f.length() );
                } catch ( final IOException e ) {
                    e.getMessage();
                }
            }
        }
    }
}