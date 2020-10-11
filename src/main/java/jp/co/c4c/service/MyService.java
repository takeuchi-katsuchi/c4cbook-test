package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.SelectMyFavoriteBooksDao;
import jp.co.c4c.db.dao.SelectMyLendHistorysDao;
import jp.co.c4c.db.dao.SelectRecomToMeBookListDao;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;

@Component
public class MyService {

    @Autowired
    SelectMyLendHistorysDao selectMyLendHistorysDao;
    @Autowired
    SelectRecomToMeBookListDao selectRecomToMeBookListDao;
    @Autowired
    SelectMyFavoriteBooksDao selectFavoriteBooksDao;

    /**
     * マイページに表示させる予約・貸出履歴のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyLendHistoryDto> getBooksByMemId(int memId) {
        return selectMyLendHistorysDao.seletctBooksByMemId(memId);
    }

    /**
     * マイページに表示させるおすすめされている本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_RecomToMeBookDto> getRecommendedBooksByMemId(int memId) {
        return selectRecomToMeBookListDao.seletctRecommendedBooksByMemId(memId);
    }
    
    /**
     * マイページに表示させるお気に入り本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyFavoriteBookDto> getMyFavoriteBooksByMemId(int memId) {
        return selectFavoriteBooksDao.seletctFavoriteBooksByMemId(memId);
    }
    
    

}
