import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import javax.imageio.ImageIO;

class ImageLoader {
    public static ImageIcon load(String path, int w, int h) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            return new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            BufferedImage fb = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = fb.createGraphics();
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, w, h);
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("No Image", w / 4, h / 2);
            g.dispose();
            return new ImageIcon(fb);
        }
    }
}