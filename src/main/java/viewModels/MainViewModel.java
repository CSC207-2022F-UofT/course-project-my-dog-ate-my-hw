package viewModels;

public class MainViewModel {
    public Theme theme;
    public TextViewModel textModel;
    public DimensionsData dimensionsData;

    public MainViewModel(String theme){
        textModel = new TextViewModel();
        dimensionsData = new DimensionsData();
        if(theme.equals("default")){
            this.theme = new DefaultTheme();
        }
    }

    public ViewFormattingData getAdoptButtonFormat(){
        ViewFormattingData formattingData = new ViewFormattingData();
        formattingData.setThemeFormat(theme.getAdoptButtonThemeFormat());
        formattingData.setText(textModel.adoptButtonTitle);
        formattingData.setPreferedSize(dimensionsData.STANDARD_BUTTONS_SIZE);
        return formattingData;
    }

}
