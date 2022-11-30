package useCases;

import presenters.UserPresenter;
import useCases.DataAccess.UserDataInterface;
import entities.User;
import useCases.DataAccess.UserResponseModel;

public class UserUC {
    final UserDataInterface userDataInterface;
    final UserPresenter userPresenter;
    private User user;

    public UserUC(UserDataInterface userDataInterface){
        this.userDataInterface = userDataInterface;
        this.userPresenter = new UserPresenter();
    }

    public User getUser() {
        return userDataInterface.getUser();
    }

    public void saveUser() {
        userDataInterface.save(this.user);
    }

    //presenter method
    public void present() {
        UserResponseModel userResponseModel = new UserResponseModel(user);
        userPresenter.show(userResponseModel);
    }
}
