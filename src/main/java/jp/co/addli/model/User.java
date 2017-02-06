package jp.co.addli.model;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;
}
