package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.SelectBookDataDao;
import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class DetailService {

    @Autowired
    private SelectBookDataDao SelectBookDataDao;

    /**
     * 詳細ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public V_TopAndDetailDto getBookById(int bookId) {
        return SelectBookDataDao.seletctBookById(bookId);
    }

    /**
     * 詳細ページに表示させる貸出履歴（ByBookId）を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getLendHistorysByBookId(int bookId) {
        return SelectBookDataDao.seletctLendHistorysById(bookId);
    }


//    @Transactional
//    public BK_T_LendDto getLendHistorysByLendId(int lendId) {
//        return detailDao.selectLendHistoryByLendId(lendId);
//    }

    /**
     * 詳細ページに表示させるお気に入りした人を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_FavoriteMemberDto> getFavoriteMembersById(int bookId) {
        return SelectBookDataDao.seletctFavoriteMembersById(bookId);
    }

    /**
     * 新規貸出履歴を登録
     * @param bk_T_LendDto
     */
    @Transactional
    public void saveLendBook(BK_T_LendDto bk_T_LendDto) {
        SelectBookDataDao.insertLendBook(bk_T_LendDto);
    }

    /**
     * 貸出履歴を更新
     * @param bk_T_LendDto
     */
    @Transactional
    public void updateLendBook(BK_T_LendDto bk_T_LendDto) {
        SelectBookDataDao.updateLendBookByLendId(bk_T_LendDto);
    }

    /**
     * 予約取り消し
     * @param lendId
     */
    @Transactional
    public void deleteLendBook(int lendId) {
        SelectBookDataDao.deleteLendBookByLendId(lendId);
    }

    /**
     * メンバー全員取得
     * @return
     */
    @Transactional
    public List<BK_M_MemBasicDto> getAllMembers(){
        return SelectBookDataDao.selectAllMembers();
    }

    /**
     * メンバーIDでメンバーを取得
     * @param memId
     * @return
     */
    @Transactional
    public BK_M_MemBasicDto getMemberById(int memId){
        return SelectBookDataDao.selectMemberByMemId(memId);
    }

    /**
     * おすすめを登録
     * @param bk_T_RecomDto
     */
    @Transactional
    public void saveRecom(BK_T_RecomDto bk_T_RecomDto){
        SelectBookDataDao.insertRecom(bk_T_RecomDto);
    }

    /**
     * レビュー登録
     * @param bk_T_LendDto
     */
    @Transactional
    public void saveReview(BK_T_LendDto bk_T_LendDto){
        SelectBookDataDao.updateLendBookforReview(bk_T_LendDto);
    }

}