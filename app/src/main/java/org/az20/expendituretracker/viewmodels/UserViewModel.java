package org.az20.expendituretracker.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import org.az20.expendituretracker.database.User;
import org.az20.expendituretracker.database.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public User findUser(String username, String password) {
        return userRepository.findUser(username, password);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
