package jp.co.c4c.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
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
     *  お知らせに表示させる貸出期限が近い本の件数を取得
     * @param memId
     * @return
     */
    public List<BK_T_LendDto> seletctLendPiriodByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookDao_LendPriodByMemberId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        return sqlManager.getResultList(BK_T_LendDto.class, sqlSrc, param);
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
