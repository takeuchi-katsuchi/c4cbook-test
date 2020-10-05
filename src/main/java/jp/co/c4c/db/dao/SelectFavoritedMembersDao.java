package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectFavoritedMembersDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させるお気に入りした人のデータを取得
     * @param bookId
     * @return
     */
    public List<V_FavoriteMemberDto> seletctFavoritedMembersById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_FavoriteDao_FavoritedBookDataByBookId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getResultList(V_FavoriteMemberDto.class, sqlSrc, param);
    }

}
