package com.api.ewys.service;

import com.api.ewys.models.UserModel;
import com.api.ewys.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс UserService - общий метод для работы с контроллерами
 */

@AllArgsConstructor
@Service
public class UserService {
    protected final IUserRepository iUserRepository;

    public List<UserModel> getUserInfoList() {
        return iUserRepository.getAll();
    }


    public UserModel getUserInfoById(long id) {
        return iUserRepository.getById(id);
    }

    public UserModel getUserInfoByLogin(@NotNull String login) {
        return iUserRepository.getByLogin(login);
    }

    public void saveUserInfo(@NotNull UserModel model) {
        iUserRepository.insertUser(model);
    }
}