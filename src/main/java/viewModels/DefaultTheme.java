package viewModels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class DefaultTheme implements Theme{
    private String themeName = "default";

    private static final Color MAIN_PANEL_BACKGROUND = new Color(247, 237, 226);
    private static final Color SIDE_PANEL_BACKGROUNDS = new Color(247, 238, 233);
    private static final Color SCROLL_BACKGROUND = new Color(251, 223, 178);
    private static final Color SCROLL_PANEL_BACKGROUND = new Color(246, 189, 96);
    private static final Color POINT_PANEL_BACKGROUND = new Color(167, 187, 182);
    private static final Color PET_PANEL_BACKGROUND = new Color(240, 177, 168);;

    private static final Color BUTTON_COLOR_1 = new Color(240, 177, 168);
    private static final Color BUTTON_COLOR_2 = new Color(242, 132, 130);
    private static final Color BUTTON_COLOR_3 = new Color(132, 165, 157);
    private static final Color BUTTON_COLOR_4 = new Color(246, 189, 96);;

    private static final Font TITLE_FONT = new Font("Krungthep", Font.PLAIN, 36);
    private static final Font BUTTON_FONT = new Font("Krungthep", Font.PLAIN, 13);
    private static final Font POINTS_FONT = new Font("Krungthep", Font.PLAIN, 18);
    private static final Font PET_NAME_FONT = new Font("Krungthep", Font.PLAIN, 20);

    private static final Color TEXT_COLOR_1 = new Color(97, 152, 142);
    private static final Color TEXT_COLOR_2 = new Color(242, 132, 130);
    private static final Color TEXT_COLOR_3 = Color.WHITE;
    private static final Color TEXT_COLOR_4 = Color.BLACK;

    private static final Color PANEL_BORDER_SHADOW = new Color(245, 202, 195);
    private static final Color BORDER_HIGHLIGHT = Color.WHITE;

    private static final int BEVEL_BORDER_TYPE = BevelBorder.RAISED;

    @Override
    public String getThemeName() {
        return themeName;
    }

    @Override
    public ThemeFormat getAdoptButtonThemeFormat(){
        Border border = BorderFactory.createBevelBorder(BEVEL_BORDER_TYPE, BUTTON_COLOR_2.brighter(), BUTTON_COLOR_2.darker());
        return new ThemeFormat(BUTTON_COLOR_2, TEXT_COLOR_3, border, BUTTON_FONT);
    }





}
