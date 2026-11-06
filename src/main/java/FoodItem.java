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

interface Billable {
    String getDisplayName();
    double getUnitPrice();
    int getQuantity();
    double getSubtotal();
}