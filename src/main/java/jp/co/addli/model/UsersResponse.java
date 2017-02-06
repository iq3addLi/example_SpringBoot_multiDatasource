package jp.co.addli.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
@Data
@AllArgsConstructor
public class UsersResponse {
    private List<User> users;
}
