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

class MenuCard extends JPanel {
    private static final Border NORMAL = BorderFactory.createLineBorder(Color.GRAY, 2);
    private static final Border HOVER = BorderFactory.createLineBorder(KioskTheme.RED, 4);

    public MenuCard(MenuItem item, Consumer<MenuItem> onClick) {
        super(new BorderLayout(5, 5));
        setBorder(NORMAL);
        setBackground(Color.WHITE);

        JPanel text = new JPanel(new GridLayout(2, 1));
        text.setBackground(Color.WHITE);
        text.add(KioskTheme.label(item.getName(), new Font("Arial", Font.BOLD, 16), Color.BLACK));
        text.add(KioskTheme.label(String.format("P%.2f", item.getPrice()),
                new Font("Arial Black", Font.BOLD, 20), KioskTheme.RED));

        add(new JLabel(ImageLoader.load(item.getImagePath(), 120, 120), SwingConstants.CENTER), BorderLayout.CENTER);
        add(text, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { onClick.accept(item); }
            @Override public void mouseEntered(MouseEvent e) { setBorder(HOVER); }
            @Override public void mouseExited(MouseEvent e) { setBorder(NORMAL); }
        });
    }
}