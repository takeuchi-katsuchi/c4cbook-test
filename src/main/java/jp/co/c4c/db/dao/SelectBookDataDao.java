package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectBookDataDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させる本のデータを取得
     * @param bookId
     * @return
     */
    public V_TopAndDetailDto seletctBookById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_DitailDao_BookDataByBookId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getSingleResult(V_TopAndDetailDto.class, sqlSrc, param);
    }

    /**
     * 詳細ページに表示させる貸出履歴のデータを取得（ByBookId）
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
     * 貸出・予約手続きに表示させる貸出履歴のデータを取得（ByLendId）
     * @param bookId
     * @return
     */
    public BK_T_LendDto selectLendHistoryByLendId(int lendId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetLendHistoryByLendId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("lendId", lendId);

        return sqlManager.getSingleResult(BK_T_LendDto.class, sqlSrc, param);
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


    /**
     * 貸出・予約手続き　データ登録
     * @param bk_T_LendDto
     */
    public void insertLendBook(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Submit_LendBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("bookId", bk_T_LendDto.getBookId());
        param.put("mId", bk_T_LendDto.getMemId());
        param.put("lstatus", bk_T_LendDto.getLendStatus());
        param.put("fromDate", bk_T_LendDto.getFromDate());
        param.put("toDate", bk_T_LendDto.getToDate());
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 貸出・予約ステータス更新
     * @param bk_T_LendDto
     */
    public void updateLendBookByLendId(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Update_LendHistoryByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("lendId", bk_T_LendDto.getLendId());
        param.put("lendStatus", bk_T_LendDto.getLendStatus());
        param.put("fromDate", bk_T_LendDto.getFromDate());
        param.put("toDate", bk_T_LendDto.getToDate());
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 貸出・予約ステータス更新
     * @param bk_T_LendDto
     */
    public void deleteLendBookByLendId(int lendId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Delete_LendBookByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("lendId", lendId);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * メンバー全員を取得
     * @return
     */
    public List<BK_M_MemBasicDto> selectAllMembers() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_MemBasicDto_SelectAllMembers.sql");
        System.out.print("Daoが接続されたよ");
        return sqlManager.getResultList(BK_M_MemBasicDto.class, sqlSrc);
    }

    /**
     * メンバーIDでメンバー取得
     * @param memId
     * @return
     */
    public BK_M_MemBasicDto selectMemberByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_MemBasicDto_SelectMemberById.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getSingleResult(BK_M_MemBasicDto.class, sqlSrc, param);
    }

    /**
     * おすすめを登録
     * @param bk_T_RecomDto
     */
    public void insertRecom(BK_T_RecomDto bk_T_RecomDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RecomeDao_Submit_RecomeBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("bookId", bk_T_RecomDto.getBookId());
        param.put("fromMemId", bk_T_RecomDto.getFromMemId());
        param.put("toMemId", bk_T_RecomDto.getToMemId());
        param.put("recomDate", date);
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 貸出履歴にレビューを登録
     * @param bk_T_RecomDto
     */
    public void updateLendBookforReview(BK_T_LendDto bk_T_RecomDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Update_LendBookforReviewByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("lendId", bk_T_RecomDto.getLendId());
        param.put("review", bk_T_RecomDto.getReview());
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}