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
import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class TopService {

    @Autowired
    private SelectBookListDao selectBookListDao;
    @Autowired
    private SelectMyFavoriteBooksDao selectFavoriteBooksDao;
    @Autowired
    private SelectMyLendHistorysDao SelectMyLendHistorysDao;
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
    public List<V_MyFavoriteBookDto> getFavoriteBooks(int memId) {
        return selectFavoriteBooksDao.seletctFavoriteBooksByMemId(memId);
    }

    /**
     * ログインユーザーが読書済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getlendedBooks(int memId) {
        return SelectMyLendHistorysDao.seletctLendHistorysByMemId(memId);
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
     * お知らせ既読ステータスを取得
     * @param memId
     * @return
     */
    @Transactional
    public BK_T_NewsReadDto getNews(int memId) {
        return selectNewsReadDataDao.seletctNewsReadData(memId);
    }

}
