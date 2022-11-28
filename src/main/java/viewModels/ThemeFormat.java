package viewModels;

import javax.swing.border.Border;
import java.awt.*;

public class ThemeFormat {

    private Color background;
    private Color textColor;
    private Border border;
    private Font font;

    public ThemeFormat(Color background, Color textColor, Border border, Font font) {
        this.background = background;
        this.textColor = textColor;
        this.font = font;
        this.border = border;
    }

    public Color getBackground() {
        return background;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Border getBorder() {
        return border;
    }

    public Font getFont() {
        return font;
    }
}
