package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.DeleteMyFavoriteBookDao;
import jp.co.c4c.db.dao.InsertMyFavoriteBookDao;
import jp.co.c4c.db.dao.SelectBookListDao;
import jp.co.c4c.db.dao.SelectMyFavoriteBooksDao;
import jp.co.c4c.db.dao.SelectMyLendHistorysDao;
import jp.co.c4c.db.dao.SelectNewsReadDataDao;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class TopService {

    @Autowired
    private SelectBookListDao selectBookListDao;
    @Autowired
    private SelectMyFavoriteBooksDao selectFavoriteBooksDao;
    @Autowired
    private SelectMyLendHistorysDao selectMyLendHistorysDao;
    @Autowired
    private InsertMyFavoriteBookDao insertMyFavoriteBookDao;
    @Autowired
    private DeleteMyFavoriteBookDao deleteMyFavoriteBookDao;
    @Autowired
    private SelectNewsReadDataDao selectNewsReadDataDao;

    /**
     * トップページに表示させる本のリストを取得
     * @return
     */
    @Transactional
    public List<V_TopAndDetailDto> getAllBooks() {
        return selectBookListDao.seletctAllBooks();
    }

    /**
     * ログインユーザーがお気に入り済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<BK_T_FavoriteDto> getFavoriteBooks(int memId) {
        return selectFavoriteBooksDao.seletctFavoriteBooksByMemId(memId);
    }

    /**
     * ログインユーザーが読書済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getlendedBooks(int memId) {
        return selectMyLendHistorysDao.seletctLendHistorysByMemId(memId);
    }

    /**
     * お気に入りの本を登録
     * @param bk_T_FavoriteDto
     */
    @Transactional
    public void saveMyFavoriteBook(BK_T_FavoriteDto bk_T_FavoriteDto) {
        insertMyFavoriteBookDao.insertMyFavoriteBook(bk_T_FavoriteDto);
    }

    /**
     * お気に入りの本を削除
     * @param bk_T_FavoriteDto
     */
    @Transactional
    public void deleteMyFavoriteBook(BK_T_FavoriteDto bk_T_FavoriteDto) {
        deleteMyFavoriteBookDao.deleteMyFavoriteBookByBookIdAndMemId(bk_T_FavoriteDto);
    }

    /**
     * 貸出期限のお知らせ情報取得用
     * @param memId
     * @return
     */
    @Transactional
    public List<BK_T_LendDto> getLendNewsByMemId(int memId) {
        return selectBookListDao.seletctLendPiriodByMemId(memId);
    }

    /**
     * お知らせの既読状態を取得
     * @param memId
     * @return
     */
    @Transactional
    public List<BK_T_NewsReadDto> getNewOfferBooks(int memId) {

        List<BK_T_NewsReadDto> testList = selectNewsReadDataDao.seletctNewsReadData(memId);

        System.out.print(testList);

        return testList;
    }

//    /**
//     * 新規提供本有無を確認
//     * @param memId
//     * @return
//     */
//    @Transactional
//    public BK_T_NewsReadDto getNewOfferBooks(int memId) {
//
//        List<V_TopAndDetailDto> newOfferBooks = selectBookListDao.seletctAllBooks();
//        Date CompairDate = new Date();
//
//        return selectNewsReadDataDao.seletctNewsReadData(memId);
//    }

}
