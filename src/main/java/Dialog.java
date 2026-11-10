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

class Dialog {
    private final Component parent;

    public Dialog(Component parent) { this.parent = parent; }

    public void message(String msg) { JOptionPane.showMessageDialog(parent, msg); }

    public void warn(String msg, String title) {
        JOptionPane.showMessageDialog(parent, msg, title, JOptionPane.WARNING_MESSAGE);
    }

    public boolean confirm(String msg, String title) {
        return JOptionPane.showConfirmDialog(parent, msg, title, JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION;
    }

    
    public int askQuantity(MenuItem item) {
        String s = JOptionPane.showInputDialog(parent,
                item.getName() + "\n" + String.format("P%.2f", item.getPrice()) + "\n\nEnter Quantity:", "1");
        if (s == null || s.trim().isEmpty()) return -1;
        try {
            int qty = Integer.parseInt(s.trim());
            if (qty > 0) return qty;
            message("Quantity must be at least 1.");
        } catch (NumberFormatException e) {
            message("Invalid number!");
        }
        return -1;
    }

    public String askItemToRemove(String[] names) {
        return (String) JOptionPane.showInputDialog(parent, "Remove:", "Select item to remove",
                JOptionPane.PLAIN_MESSAGE, null, names, names[0]);
    }

    public String askDiscountType() {
        Object[] opts = {"Senior Citizen", "PWD", "Cancel"};
        int c = JOptionPane.showOptionDialog(parent, "Select Discount (20%):", "Discount",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[2]);
        return (c == 0 || c == 1) ? (String) opts[c] : null;
    }

    public void showReceipt(String text) {
        JTextArea area = new JTextArea(text);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(480, 500));
        JOptionPane.showMessageDialog(parent, scroll, "Receipt", JOptionPane.PLAIN_MESSAGE);
    }
}