package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_RequestDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectRequestListDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 要望ページに表示させるデータを取得
     * @param
     * @return
     */
    public List<V_RequestDto> seletctRequestList() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestDao_RequestData.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();

        return sqlManager.getResultList(V_RequestDto.class, sqlSrc, param);
    }

}
