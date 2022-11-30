package useCases;

public class RefresherFactory {
    public Refresher createRefresher(String type){
        if(type.equals("Pet")) {
            return new PetRefresher();
        }
        else if(type.equals("Tasklist")){
            return new TasklistRefresher();
        }
        else{
            return null;
        }
    }
}
