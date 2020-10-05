package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_MyPageDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class SelectBookListDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * トップページに表示させる本リストのデータを取得
     * @return
     */
    public List<V_TopAndDetailDto> seletctAllBooks() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_TopDao_getAllBooks.sql");
        System.out.print("Daoが接続されたよ");

        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc);
    }

    /**
     * マイページに表示させる本のリストを取得
     * @param memId
     * @return
     */
    public List<V_MyPageDto> seletctBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookDao_BookDataByMemberId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        return sqlManager.getResultList(V_MyPageDto.class, sqlSrc, param);
    }

}
