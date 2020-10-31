package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_RecomMemDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class SelectRecomMemByBookIdDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させるおすすめしている人をBookIdで取得
     * @param bookId
     * @return
     */
    public List<V_RecomMemDto> seletctRecomMembersByBookId(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RecomeDao_RecomeBookByBookId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        return sqlManager.getResultList(V_RecomMemDto.class, sqlSrc, param);
    }

}
