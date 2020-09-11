package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.SelectRequestListDao;
import jp.co.c4c.db.dto.V_RequestDto;

@Component
public class RequestService {

    @Autowired
    private SelectRequestListDao selectRequestListDao;

    /**
     * 要望ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_RequestDto> getRequestList() {
        return selectRequestListDao.seletctRequestList();
    }
}
