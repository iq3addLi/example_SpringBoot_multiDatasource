package jp.co.addli.config;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */

public class DBContextHolder {

    private static final ThreadLocal<DBType> contextHolder = new ThreadLocal<DBType>();

    public static void setDBType(DBType DBType) {
        if(DBType == null){
            throw new NullPointerException();
        }
        contextHolder.set(DBType);
    }

    public static DBType getDBType() {
        return (DBType) contextHolder.get();
    }

    public static void clearDBType() {
        contextHolder.remove();
    }
}