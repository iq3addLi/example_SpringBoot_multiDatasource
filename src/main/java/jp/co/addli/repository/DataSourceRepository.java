package jp.co.addli.repository;

import javax.sql.DataSource;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
public interface DataSourceRepository {
    DataSource getDataSource();
}
