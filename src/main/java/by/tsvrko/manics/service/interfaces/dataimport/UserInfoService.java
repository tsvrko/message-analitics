package main.java.by.tsvrko.manics.service.interfaces.dataimport;

import main.java.by.tsvrko.manics.model.dataimport.AuthInfo;
import main.java.by.tsvrko.manics.model.dataimport.UserInfo;

import java.util.List;

/**
 * Created main.main.java.by tsvrko on 2/10/2017.
 */
public interface UserInfoService {

    List<UserInfo> getUsers(List<Integer> list, AuthInfo authInfo);

    UserInfo getUser(AuthInfo authInfo);

}
