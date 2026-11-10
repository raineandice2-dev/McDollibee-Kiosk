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

public class McDollibee extends JFrame {

    private final Cart cart = new Cart();
    private final Dialog dialogs = new Dialog(this);
    private int orderNumber = 1;

    private JPanel itemsPanel;
    private JTextArea cartDisplay;
    private JLabel totalLabel;

    public McDollibee() {
        setTitle("McDollibee");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = KioskTheme.label(" McDollibee DIGITAL KIOSK ",
                new Font("Arial Black", Font.BOLD, 32), KioskTheme.YELLOW);
        title.setOpaque(true);
        title.setBackground(KioskTheme.RED);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(1, 2, 20, 20));
        main.add(createMenuPanel());
        main.add(createCartPanel());
        add(main, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);

        refresh();
        setVisible(true);
    }
    
    private JPanel createMenuPanel() {
        JPanel panel = KioskTheme.titledPanel("MENU CATEGORIES");
        JPanel cats = new JPanel(new GridLayout(MenuData.CATEGORIES.length, 1, 15, 15));
        for (int i = 0; i < MenuData.CATEGORIES.length; i++) {
            final int idx = i;
            cats.add(KioskTheme.button(MenuData.CATEGORIES[i], KioskTheme.YELLOW, KioskTheme.RED,
                    e -> showCategoryItems(idx)));
        }
        panel.add(cats, BorderLayout.WEST);
        itemsPanel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.add(itemsPanel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCartPanel() {
        JPanel panel = KioskTheme.titledPanel("SHOPPING CART");
        cartDisplay = new JTextArea(20, 30);
        cartDisplay.setEditable(false);
        cartDisplay.setFont(new Font("Monospaced", Font.BOLD, 14));
        panel.add(new JScrollPane(cartDisplay), BorderLayout.CENTER);

        totalLabel = KioskTheme.label("", new Font("Arial Black", Font.BOLD, 28), KioskTheme.RED);
        totalLabel.setOpaque(true);
        totalLabel.setBackground(Color.WHITE);
        totalLabel.setBorder(BorderFactory.createLineBorder(KioskTheme.RED, 4));
        panel.add(totalLabel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createControlPanel() {
        JPanel p = new JPanel(new GridLayout(1, 5, 15, 15));
        p.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        p.setBackground(KioskTheme.RED);

        p.add(KioskTheme.button("REMOVE", Color.ORANGE, Color.BLACK, e -> removeItem()));
        p.add(KioskTheme.button("CLEAR", Color.RED, Color.WHITE, e -> clearCart()));
        p.add(KioskTheme.button("DISCOUNT", Color.MAGENTA, Color.WHITE, e -> applyDiscount()));
        p.add(KioskTheme.button("CHECKOUT", Color.GREEN, Color.BLACK, e -> checkout()));
        
      p.add(KioskTheme.button("SEARCH", Color.YELLOW, Color.BLACK, e -> {
    String query = JOptionPane.showInputDialog(this, "Enter food name to search in menu:");
    if (query != null && !query.trim().isEmpty()) {
        MenuItem found = MenuData.searchMenuItem(query);
        if (found != null) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Found Item: " + found.getName() + " - P" + found.getPrice() + "\nWould you like to add this to your cart?", 
                "Search Result", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                addToCart(found);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Item not found in the menu.");
        }
    }
}));

        return p;
    }

    private void showCategoryItems(int cat) {
        itemsPanel.removeAll();
        for (MenuItem item : MenuData.ITEMS[cat]) itemsPanel.add(new MenuCard(item, this::addToCart));
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    private void refresh() {
        cartDisplay.setText(Receipt.buildTable(cart));
        totalLabel.setText(String.format("TOTAL: %.2f", cart.getTotal()));
    }

    private void addToCart(MenuItem item) {
        int qty = dialogs.askQuantity(item);
        if (qty > 0) {
            cart.add(item, qty);
            refresh();
        }
    }

    private void removeItem() {
        if (cart.isEmpty()) { dialogs.message("Cart empty!"); return; }
        String sel = dialogs.askItemToRemove(cart.getNames());
        if (sel != null) {
            cart.remove(sel);
            refresh();
        }
    }

    private void clearCart() {
        if (!cart.isEmpty() && dialogs.confirm("Clear all?", "Confirm")) {
            cart.clear();
            refresh();
        }
    }

    private void applyDiscount() {
        if (cart.isEmpty()) { dialogs.message("Add items to the cart first."); return; }
        if (cart.isDiscountUsed()) {
            dialogs.warn("A discount (" + cart.getDiscountType() + ") was already applied.\n"
                    + "Discount can only be used once.", "Discount");
            return;
        }
        String type = dialogs.askDiscountType();
        if (type != null) {
            cart.applyDiscount(type);
            refresh();
        }
    }

    private void checkout() {
        if (cart.isEmpty()) { dialogs.warn("Your cart is empty!", "Checkout"); return; }
        if (!dialogs.confirm(String.format("Total Amount: P%.2f%nProceed to checkout?", cart.getTotal()), "Checkout"))
            return;
        dialogs.showReceipt(Receipt.buildReceipt(cart, orderNumber++));
        cart.clear();
        refresh();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(McDollibee::new);
    }
}