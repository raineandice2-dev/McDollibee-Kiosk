import javax.swing.*;
import java.awt.*;

class MenuData {
    private static final String DIR = "C:\\Users\\raine\\Pictures\\Screenshots\\";

    public static final String[] CATEGORIES = {"Rice Meals", "Bucket Meals", "Soups", "Drinks", "Desserts"};

    public static final MenuItem[][] ITEMS = {
        {
            new MenuItem("Chickenjoy Rice", 60.00, DIR + "Screenshot 2026-11-05 010110.png"),
            new MenuItem("Pork Adobo Rice", 70.00, DIR + "Screenshot 2026-11-05 010202.png"),
            new MenuItem("Beef Caldereta Rice", 70.00, DIR + "Screenshot 2026-11-05 010248.png")
        },
        {
            new MenuItem("Chicken Bucket", 250.00, DIR + "Screenshot 2026-11-05 010350.png"),
            new MenuItem("Family Bucket", 450.00, DIR + "Screenshot 2026-11-05 010417.png"),
            new MenuItem("Spicy Bucket", 380.00, DIR + "Screenshot 2026-11-05 010451.png")
        },
        {
            new MenuItem("Bulalo", 60.00, DIR + "Screenshot 2026-11-05 010522.png"),
            new MenuItem("Sinigang", 60.00, DIR + "Screenshot 2026-11-05 010544.png"),
            new MenuItem("Chicken Mami", 60.00, DIR + "Screenshot 2026-11-05 010600.png")
        },
        {
            new MenuItem("Coke", 55.00, DIR + "Screenshot 2026-11-05 011608.png"),
            new MenuItem("Sprite", 55.00, DIR + "Screenshot 2026-11-05 011633.png"),
            new MenuItem("Iced Tea", 55.00, DIR + "Screenshot 2026-11-05 011659.png"),
            new MenuItem("Royal", 55.00, DIR + "Screenshot 2026-11-05 011738.png"),
            new MenuItem("Pineapple Juice", 55.00, DIR + "Screenshot 2026-11-05 011804.png")
        },
        {
            new MenuItem("Halo-Halo", 65.00, DIR + "Screenshot 2026-11-05 011823.png"),
            new MenuItem("Leche Flan", 55.00, DIR + "Screenshot 2026-11-05 011854.png"),
            new MenuItem("Peach Mango Pie", 75.00, DIR + "Screenshot 2026-11-05 011929.png")
        }
    };

    public static MenuItem searchMenuItem(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return null;
        
        
        for (int cat = 0; cat < ITEMS.length; cat++) {
            for (MenuItem item : ITEMS[cat]) {
                if (item.getName().equalsIgnoreCase(keyword.trim())) {
                    return item; // Found it!
                }
            }
        }
        return null; // Not found
    }
}