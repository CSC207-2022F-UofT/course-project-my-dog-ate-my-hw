package useCases;

public class BuyHeartUC {
    /**
    * Updates the User's balance and the corresponding Pet's health (1:1)
    * @param hearts the number of hearts to heal (cost)
    * @param user the User's name
    */
    public static void buyHeart(entities.User user, int hearts){
    
        entities.Pet pet = user.getPet();

        if(user.getPoints() > 0 &&
                pet.getCurrHealth() > 0 &&
                pet.getCurrHealth() < entities.Pet.getMaxHealth()){
            user.LosePoints(hearts);
            pet.heal(hearts);
        }
    }

    /**
     * Calls the User UseCase for a User and then calls buyHeart(user, hearts)
     * @param hearts the number of hearts to heal (cost)
     */
    public static void buyHeart(int hearts){
        User user = User.u();
        buyHeart(user, hearts);
    }

    public void refresh(){
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }

}
