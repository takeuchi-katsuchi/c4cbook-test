package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class UpdateLendBookDao {

    @Autowired
    public SqlManager sqlManager;

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
