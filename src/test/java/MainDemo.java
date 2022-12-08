import entities.Customization;
import entities.CustomizationTest;
import entities.Item;

public class MainDemo {

    private void initalizeDefaultCustomizationList(){
        Customization customizations = new Customization();
        Item halo = new Item("Hat", "Halo", 1, "Halo", false);
        customizations.addItem(halo);
    }
}
