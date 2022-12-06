package viewModels;

public class MainViewModel {
    public Theme theme;
    public TextViewModel textModel;

    public MainViewModel(String theme){
        textModel = new TextViewModel();
        if(theme.equals("default")){
            this.theme = new DefaultTheme();
        }
    }

    public ViewFormattingData getAdoptButtonFormat(){
        ViewFormattingData formattingData = new ViewFormattingData();
        formattingData.setThemeFormat(theme.getAdoptButtonThemeFormat());
        formattingData.setText(textModel.adoptButtonTitle);
        return formattingData;
    }

}
