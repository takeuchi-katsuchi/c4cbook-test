package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class SelectMemberDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * メンバー全員を取得
     * @return
     */
    public List<BK_M_MemBasicDto> selectAllMembers() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_MemBasicDto_SelectAllMembers.sql");
        return sqlManager.getResultList(BK_M_MemBasicDto.class, sqlSrc);
    }

    /**
     * メンバーIDでメンバー取得
     * @param memId
     * @return
     */
    public BK_M_MemBasicDto selectMemberByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_MemBasicDto_SelectMemberById.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getSingleResult(BK_M_MemBasicDto.class, sqlSrc, param);
    }

}
