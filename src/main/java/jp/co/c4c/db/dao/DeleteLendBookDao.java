package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class DeleteLendBookDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 予約取り消し
     * @param bk_T_LendDto
     */
    public void deleteLendBookByLendId(int lendId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Delete_LendBookByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("lendId", lendId);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
