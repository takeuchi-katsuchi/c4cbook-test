package jp.co.c4c.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.db.dao.DetailDao;

@Component
public class DetailService {

    @Autowired
    private DetailDao detailDao;

    @Transactional
    public DetailForm getBookById(int bookId) {
        return detailDao.seletctBookById(bookId);
    }

}
