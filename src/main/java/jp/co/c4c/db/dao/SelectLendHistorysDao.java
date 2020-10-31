package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectLendHistorysDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させる貸出履歴のデータを取得
     * @param bookId
     * @return
     */
    public List<V_LendHistoryDto> seletctLendHistorysById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetLendHistorys.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        return sqlManager.getResultList(V_LendHistoryDto.class, sqlSrc, param);
    }

}
