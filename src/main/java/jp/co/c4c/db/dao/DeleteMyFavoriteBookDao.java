package jp.co.c4c.db.dao;

import java.util.HashMap;
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
public class DeleteMyFavoriteBookDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * お気に入りの本を削除
     * @param bk_T_FavoriteDto
     */
    public void deleteMyFavoriteBookByBookIdAndMemId(BK_T_FavoriteDto bk_T_FavoriteDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_FavoriteDao_Delete_MyFavoriteBook.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bk_T_FavoriteDto.getBookId());
        param.put("memId", bk_T_FavoriteDto.getMemId());
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
