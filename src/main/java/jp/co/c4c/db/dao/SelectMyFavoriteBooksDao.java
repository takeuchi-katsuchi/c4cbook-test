package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectMyFavoriteBooksDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * ログインユーザーがお気に入り済みの本のリストを取得
     * @param memId
     * @return
     */
    public List<BK_T_FavoriteDto> seletctFavoriteBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_FavoriteDao_FavoritedBookDataByMenberId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(BK_T_FavoriteDto.class, sqlSrc, param);
    }
}
