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

class CartItem implements Billable {
    private String name;
    private double unitPrice;
    private int quantity;

    public CartItem(String name, double unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override public String getDisplayName() { return name; }
    @Override public double getUnitPrice() { return unitPrice; }
    @Override public int getQuantity() { return quantity; }
    @Override public double getSubtotal() { return unitPrice * quantity; }

    public void setQuantity(int quantity) { if (quantity > 0) this.quantity = quantity; }
    public void addQuantity(int extra) { if (extra > 0) this.quantity += extra; }
}