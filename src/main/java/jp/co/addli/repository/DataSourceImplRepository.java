package jp.co.addli.repository;

import jp.co.addli.config.DBContextHolder;

import javax.sql.DataSource;
import java.util.List;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */
public class DataSourceImplRepository implements DataSourceRepository{

    private List<DataSource> dataSources;

    public DataSourceImplRepository(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public DataSource getDataSource(){
        return dataSources.get(DBContextHolder.getDBType().ordinal());
    }
}
