package presenters;

import useCases.DataAccess.UserResponseModel;

/* A general presenter interface to be implemented by each presenter */
public interface UserPresenterInt {
    void show(UserResponseModel userResponseModel);
}
