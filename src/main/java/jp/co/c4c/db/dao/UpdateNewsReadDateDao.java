package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class UpdateNewsReadDateDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 既読日時更新
     * @param memId
     */
    public void updateNewsReadDateByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_NewsReadDao_Update.sql");
        Map<String, Object> param = new HashMap<>();

        sqlManager.executeUpdate(sqlSrc, param);
    }
}
