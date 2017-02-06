package jp.co.addli.controller;

import jp.co.addli.model.UsersResponse;
import jp.co.addli.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
@RestController
@RequestMapping(value = "/{*}" )
@Slf4j
public class Controller {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsersResponse users() {
        return new UsersResponse(userRepo.getUsers());
    }
}
