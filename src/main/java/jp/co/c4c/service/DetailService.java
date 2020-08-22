package jp.co.c4c.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.DetailDao;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class DetailService {

    @Autowired
    private DetailDao detailDao;

    @Transactional
    public V_TopAndDetailDto getBookById(int bookId) {
        return detailDao.seletctBookById(bookId);
    }

}
