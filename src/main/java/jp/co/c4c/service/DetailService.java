package jp.co.c4c.service;

import java.util.List;

import jp.co.c4c.db.dao.*;
import jp.co.c4c.db.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DetailService {

    @Autowired
    private SelectBookDataDao selectBookDataDao;
    @Autowired
    private SelectLendHistorysDao selectLendHistorysDao;
    @Autowired
    private SelectFavoritedMembersDao selectFavoritedMembersDao;
    @Autowired
    private SelectRecomMemByBookIdDao selectRecomMemByBookIdDao;
    @Autowired
    private InsertLendBookDao insertLendBookDao;
    @Autowired
    private UpdateLendBookDao updateLendBookDao;
    @Autowired
    private DeleteLendBookDao deleteLendBookDao;
    @Autowired
    private SelectMemberDao selectMemberDao;
    @Autowired
    private InsertRecomDao insertRecomDao;

    /**
     * 詳細ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public V_TopAndDetailDto getBookById(int bookId) {
        return selectBookDataDao.seletctBookById(bookId);
    }

    /**
     * 詳細ページに表示させる貸出履歴（ByBookId）を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getLendHistorysByBookId(int bookId) {
        return selectLendHistorysDao.seletctLendHistorysById(bookId);
    }

    /**
     * 詳細ページに表示させるお気に入りした人を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_FavoriteMemberDto> getFavoriteMembersById(int bookId) {
        return selectFavoritedMembersDao.seletctFavoritedMembersById(bookId);
    }

    /**
     * 詳細ページに表示させるおすすめしている人をBookIdで取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_RecomMemDto> getRecomMembersById(int bookId) {
        return selectRecomMemByBookIdDao.seletctRecomMembersByBookId(bookId);
    }

    /**
     * 新規貸出履歴を登録
     * @param bk_T_LendDto
     */
    @Transactional
    public void saveLendBook(BK_T_LendDto bk_T_LendDto) {
        insertLendBookDao.insertLendBook(bk_T_LendDto);
    }

    /**
     * 貸出履歴を更新
     * @param bk_T_LendDto
     */
    @Transactional
    public void updateLendBook(BK_T_LendDto bk_T_LendDto) {
        updateLendBookDao.updateLendBookByLendId(bk_T_LendDto);
    }

    /**
     * 予約取り消し
     * @param lendId
     */
    @Transactional
    public void deleteLendBook(int lendId) {
        deleteLendBookDao.deleteLendBookByLendId(lendId);
    }

    /**
     * メンバー全員取得
     * @return
     */
    @Transactional
    public List<BK_M_MemBasicDto> getAllMembers() {
        return selectMemberDao.selectAllMembers();
    }

    /**
     * メンバーIDでメンバーを取得
     * @param memId
     * @return
     */
    @Transactional
    public BK_M_MemBasicDto getMemberById(int memId) {
        return selectMemberDao.selectMemberByMemId(memId);
    }

    /**
     * おすすめを登録
     * @param bk_T_RecomDto
     */
    @Transactional
    public void saveRecom(BK_T_RecomDto bk_T_RecomDto) {
        insertRecomDao.insertRecom(bk_T_RecomDto);
    }

    /**
     * レビュー登録
     * @param bk_T_LendDto
     */
    @Transactional
    public void saveReview(BK_T_LendDto bk_T_LendDto) {
        updateLendBookDao.updateLendBookforReview(bk_T_LendDto);
    }

}
