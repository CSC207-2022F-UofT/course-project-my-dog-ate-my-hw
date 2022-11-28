package viewModels;

import javax.swing.border.Border;
import java.awt.*;

public class ViewFormattingData {

    private ThemeFormat themeFormat;
    private String text;
    private Dimension preferedSize;

    public void setThemeFormat(ThemeFormat themeFormat) {
        this.themeFormat = themeFormat;
    }

    public void setPreferedSize(Dimension preferedSize) {
        this.preferedSize = preferedSize;
    }

    public void setText(String text){
        this.text = text;
    }

    public ThemeFormat getThemeFormat() {
        return themeFormat;
    }

    public Dimension getPreferedSize() {
        return preferedSize;
    }

    public String getText() {
        return text;
    }
}
