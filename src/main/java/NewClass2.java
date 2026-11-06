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

class Cart {
    public static final double DISCOUNT_RATE = 0.20;

    private ArrayList<CartItem> items = new ArrayList<>();
    private boolean discountUsed = false;
    private String discountType = "";

    public ArrayList<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
    public boolean isDiscountUsed() { return discountUsed; }
    public String getDiscountType() { return discountType; }

    public CartItem find(String name) {
        for (CartItem c : items) {
            if (c.getDisplayName().equals(name)) return c;
        }
        return null;
    }

    public void add(MenuItem item, int qty) {
        CartItem existing = find(item.getName());
        if (existing != null) existing.addQuantity(qty);
        else items.add(new CartItem(item.getName(), item.getPrice(), qty));
    }

    public void remove(String name) {
        CartItem c = find(name);
        if (c != null) items.remove(c);
        if (items.isEmpty()) resetDiscount();
    }

    public void clear() {
        items.clear();
        resetDiscount();
    }

    public String[] getNames() {
        String[] names = new String[items.size()];
        for (int i = 0; i < names.length; i++) names[i] = items.get(i).getDisplayName();
        return names;
    }

    public boolean applyDiscount(String type) {
        if (discountUsed) return false;
        discountUsed = true;
        discountType = type;
        return true;
    }

    private void resetDiscount() {
        discountUsed = false;
        discountType = "";
    }

    public double getSubtotal() {
        double sum = 0;
        for (Billable b : items) sum += b.getSubtotal();
        return sum;
    }

    public double getDiscountAmount() { return discountUsed ? getSubtotal() * DISCOUNT_RATE : 0.0; }
    public double getTotal() { return getSubtotal() - getDiscountAmount(); }

    // --- SEARCH ALGORITHM (Linear Search) ---
public CartItem linearSearchCartItem(String targetName) {
    for (int i = 0; i < items.size(); i++) {
        CartItem c = items.get(i);
        if (c.getDisplayName().equalsIgnoreCase(targetName)) {
            return c; // Found the item!
        }
    }
    return null; // Not found
}


public void performSearchUI(java.awt.Component parentComponent) {
    String searchKeyword = JOptionPane.showInputDialog(parentComponent, "Enter item name to search in cart:");
    
    if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
        CartItem foundItem = linearSearchCartItem(searchKeyword);
        
        if (foundItem != null) {
            JOptionPane.showMessageDialog(parentComponent, 
                "Item Found in Cart!\n" +
                "Name: " + foundItem.getDisplayName() + "\n" +
                "Quantity: " + foundItem.getQuantity() + "\n" +
                "Subtotal: ₱" + String.format("%.2f", foundItem.getSubtotal()));
        } else {
            JOptionPane.showMessageDialog(parentComponent, "Item not found in your cart.");
        }
    }
}
}

