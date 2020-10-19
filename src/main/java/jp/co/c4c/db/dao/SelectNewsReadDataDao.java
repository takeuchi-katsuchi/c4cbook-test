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
    public SqlManager sqlManager;

    /**
     * お知らせの未読情報を取得
     * @param memId
     * @return
     */
    public BK_T_NewsReadDto seletctNewsReadTime(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_NewsReadDao_getReadTime.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        // sql実行のため力技でパラメータを設定
        String sqlPramOrg = param.toString();
        char sqlPram = sqlPramOrg.charAt(7);

        return sqlManager.getSingleResultBySql(BK_T_NewsReadDto.class,
                "select READ_AT from book_db.BK_T_NEWS_READ where book_db.BK_T_NEWS_READ.MEM_ID = " + sqlPram);
        //           return sqlManager.getSingleResult(BK_T_NewsReadDto.class,sqlSrc,param);
    }

}