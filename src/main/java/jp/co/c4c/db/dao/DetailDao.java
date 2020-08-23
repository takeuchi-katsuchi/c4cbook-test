package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class DetailDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させる本のデータを取得
     * @param bookId
     * @return
     */
    public V_TopAndDetailDto seletctBookById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetDetailBook.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getSingleResult(V_TopAndDetailDto.class, sqlSrc, param);
    }


    /**
     * 詳細ページに表示させる貸出履歴のデータを取得
     * @param bookId
     * @return
     */
    public List<V_LendHistoryDto> seletctLendHistorysById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetLendHistorys.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getResultList(V_LendHistoryDto.class, sqlSrc, param);
    }

    /**
     * 詳細ページに表示させるお気に入りした人のデータを取得
     * @param bookId
     * @return
     */
    public List<V_FavoriteMemberDto> seletctFavoriteMembersById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetFavoriteMembers.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getResultList(V_FavoriteMemberDto.class, sqlSrc, param);
    }



}
