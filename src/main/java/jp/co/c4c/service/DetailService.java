package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.DetailDao;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class DetailService {

    @Autowired
    private DetailDao detailDao;

    /**
     * 詳細ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public V_TopAndDetailDto getBookById(int bookId) {
        return detailDao.seletctBookById(bookId);
    }

    /**
     * 詳細ページに表示させる貸出履歴を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getLendHistorysById(int bookId) {
        return detailDao.seletctLendHistorysById(bookId);
    }

    /**
     * 詳細ページに表示させるお気に入りした人を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_FavoriteMemberDto> getFavoriteMembersById(int bookId) {
        return detailDao.seletctFavoriteMembersById(bookId);
    }

}
