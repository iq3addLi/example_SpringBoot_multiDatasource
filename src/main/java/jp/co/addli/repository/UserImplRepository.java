package jp.co.addli.repository;

import jp.co.addli.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
public class UserImplRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private DataSourceRepository dataSourceRepo;

    public UserImplRepository(DataSourceRepository dataSource) {
        dataSourceRepo = dataSource;
    }

    private JdbcTemplate template(){
        if ( jdbcTemplate == null ){
            jdbcTemplate = new JdbcTemplate( dataSourceRepo.getDataSource() );
        }else{
            jdbcTemplate.setDataSource( dataSourceRepo.getDataSource() );
        }

        return jdbcTemplate;
    }

    public List<User> getUsers(){

        List<User> list = template().query(
                "SELECT name, password FROM users",
                new BeanPropertyRowMapper<>(User.class));

        return list;
    }
}
