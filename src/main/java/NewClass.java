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

class MenuItem {
    private String name;
    private double price;
    private String imagePath;

    public MenuItem(String name, double price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { if (price >= 0) this.price = price; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}