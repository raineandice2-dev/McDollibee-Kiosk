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

class KioskTheme {
    public static final Color RED = new Color(200, 16, 46);
    public static final Color YELLOW = new Color(255, 204, 0);
    public static final Font BIG = new Font("Arial Black", Font.BOLD, 18);

    public static JButton button(String text, Color bg, Color fg, ActionListener action) {
        JButton b = new JButton(text);
        b.setFont(BIG);
        b.setBackground(bg);
        b.setForeground(fg);
        b.setFocusPainted(false);
        b.addActionListener(action);
        return b;
    }

    public static JPanel titledPanel(String title) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(RED, 4), title));
        return p;
    }

    public static JLabel label(String text, Font font, Color color) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setFont(font);
        l.setForeground(color);
        return l;
    }
}