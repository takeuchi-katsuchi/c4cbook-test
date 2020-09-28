package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RequestCheerDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
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
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_V_SelectRequestListDao_RequestData.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();

        return sqlManager.getResultList(V_RequestDto.class, sqlSrc, param);
    }

    /**
     * 要望　データ登録
     * @param BK_T_RequestDto
     */
    public void insertRequestBook(BK_T_RequestDto bK_T_RequestDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestDao_Upsert_RequestData.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("title", bK_T_RequestDto.getTitle());
        param.put("titleKana", bK_T_RequestDto.getTitleKana());
        param.put("author", bK_T_RequestDto.getAuthor());
        param.put("authorKana", bK_T_RequestDto.getAuthorKana());
        param.put("mem_id", bK_T_RequestDto.getMem_id());
        param.put("comment", bK_T_RequestDto.getComment());
        param.put("requestStatus", 0);
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 応援　データ登録
     * @param BK_T_RequestDto
     */
    public void insertCheerBook(BK_T_RequestCheerDto bK_T_RequestCheerDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestCheerDao_Submit_RequestCheer.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("requestId", bK_T_RequestCheerDto.getRequestId());
        param.put("memId", bK_T_RequestCheerDto.getMemId());
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
