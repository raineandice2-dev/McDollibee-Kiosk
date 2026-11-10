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

class Receipt {
    private static final int W = 42;

    private static String shorten(String s, int max) {
        return s.length() <= max ? s : s.substring(0, max - 1) + ".";
    }

    private static String center(String text) {
        return " ".repeat(Math.max(0, (W - text.length()) / 2)) + text;
    }

    public static String buildTable(Cart cart) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-18s %4s %8s %9s%n", "ITEM", "QTY", "PRICE", "TOTAL"));
        sb.append("-".repeat(W)).append("\n");
        for (CartItem c : cart.getItems()) {
            sb.append(String.format("%-18s %4d %8.2f %9.2f%n",
                    shorten(c.getDisplayName(), 18), c.getQuantity(), c.getUnitPrice(), c.getSubtotal()));
        }
        sb.append("-".repeat(W)).append("\n");
        sb.append(String.format("%-32s %9.2f%n", "Subtotal:", cart.getSubtotal()));
        if (cart.isDiscountUsed()) {
            sb.append(String.format("%-32s %9.2f%n",
                    "Discount (" + cart.getDiscountType() + "):", -cart.getDiscountAmount()));
        }
        sb.append(String.format("%-32s %9.2f%n", "TOTAL:", cart.getTotal()));
        return sb.toString();
    }

    public static String buildReceipt(Cart cart, int orderNo) {
        String date = new SimpleDateFormat("MMM dd, yyyy  hh:mm a").format(new Date());
        String line = "=".repeat(W);
        return line + "\n"
                + center("McDollibee") + "\n"
                + center("OFFICIAL RECEIPT") + "\n"
                + line + "\n"
                + String.format("Order No: %04d%n", orderNo)
                + "Date    : " + date + "\n"
                + "-".repeat(W) + "\n"
                + buildTable(cart)
                + line + "\n"
                + center("Thank you for dining with us!") + "\n"
                + center("Please come again :)") + "\n"
                + line + "\n";
    

    }
}