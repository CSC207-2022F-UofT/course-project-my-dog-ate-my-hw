package useCases;

import entities.User;
import entities.Pet;

public class BuyHeartUC implements BuyHeartInputBoundary{

    /**
    * Updates the User's balance and the corresponding Pet's health (1:1)
    * @param hearts the number of hearts to heal (cost)
    * @param user the User's name
    */
    public void buyHeart(User user, int hearts){
    
        Pet pet = user.getPet();
        
        if(user.getPoints() > 0 &&
                pet.getCurrHealth() > 0 &&
                pet.getCurrHealth() < Pet.getMaxHealth()){
            user.LosePoints(hearts);
            pet.heal(hearts);
        }
    }

    public void buyHeart(int hearts){
        buyHeart(UserUC.u(), hearts);
    }

    public void buyHeart(){
        buyHeart(UserUC.u(), 1);
    }

    public void refreshPet(){
        new PetRefresher().refresh();
    }

}