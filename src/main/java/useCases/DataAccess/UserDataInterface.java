package useCases.DataAccess;

import entities.User;

public interface UserDataInterface {
    User getUser();

    /**
     * set the user in DataBase
     * @param user The data to set.
     */
    void save(User user);
}
