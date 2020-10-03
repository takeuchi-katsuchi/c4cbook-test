package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.SelectBookListDao;
import jp.co.c4c.db.dto.V_MyPageDto;

@Component
public class MyService {

    @Autowired
    SelectBookListDao selectBookListDao;

    @Transactional
    public List<V_MyPageDto> getBooksByMemId(int memId){
        return selectBookListDao.seletctBooksByMemId(memId);
    }
}
