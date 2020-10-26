package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
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
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookListDao_getAllBooks.sql");
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
     * お知らせに表示させる新規入荷本のデータを取得
     * @param readTime
     * @return
     */
    public List<V_TopAndDetailDto> seletctOfferBookNewsData(Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookListDao_getNewBooks.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("readTime", readTime);
        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させる承認された本のデータを取得
     * @param memId,readTime
     * @return
     */
    public List<BK_T_RequestDto> seletctRequestBookNewsData(int memId,Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookListDao_getNewsRequestBook.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        param.put("readTime", readTime);
        return sqlManager.getResultList(BK_T_RequestDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させるおすすめされた本のデータを取得
     * @param memId,readTime
     * @return
     */
    public List<BK_T_RecomDto> seletctRecomeBookNewsData(int memId,Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookListDao_getNewsRecometBook.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        param.put("readTime", readTime);
        return sqlManager.getResultList(BK_T_RecomDto.class, sqlSrc, param);
    }

}