package jp.co.addli.repository;

import jp.co.addli.model.User;

import java.util.List;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
public interface UserRepository {
    List<User> getUsers();
}
