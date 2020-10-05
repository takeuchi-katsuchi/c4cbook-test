package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class SelectNewsReadDataDao {

    @Autowired
    public static SqlManager sqlManager;

    /**
     * お知らせの未読情報を取得
     * @param memId
     * @return
     */
    public BK_T_NewsReadDto  seletctNewsReadData(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_NewsReadDao_getReadTime.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getSingleResult(BK_T_NewsReadDto.class, sqlSrc, param);
    }

}