package viewModels;

import java.awt.*;

public interface Theme {

    // INSTANCE VARIABLES //
    String getThemeName();

    Color getPrimaryColor1();
    Color getPrimaryColor2();
    Color getPrimaryColor3();

    Color getSecondaryColor1();
    Color getScondaryColor2();
    Color getSecondaryColor3();

    Color getTextColor1();
    Color getTextColor2();

    Font getTitleFont();
    Font getButtonsFont();
    Font getOtherFont();

}
