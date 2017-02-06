package jp.co.addli.config;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */

public class DBContextHolder {

    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>();

    public static void setDbType(DbType dbType) {
        if(dbType == null){
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static DbType getDbType() {
        return (DbType) contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}