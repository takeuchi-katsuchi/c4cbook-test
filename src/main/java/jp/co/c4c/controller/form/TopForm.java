package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * トップ画面 Formクラス
 */
public class TopForm {

    List<V_TopAndDetailDto> topAndDetailDtoList;
    List<BK_T_NewsReadDto> readStatus;
    List<Integer> myFavoriteBookIdList;
    List<Integer> myLendedBookIdList;
    List<V_MyPageDto> myLendingBookList;
    List<BK_T_LendDto> lendNewsList;
    List<V_MyLendHistoryDto> myLendingBookList;

    public List<V_TopAndDetailDto> getTopAndDetailDtoList() {
        return topAndDetailDtoList;
    }

    public void setTopAndDetailDtoList(List<V_TopAndDetailDto> topAndDetailDtoList) {
        this.topAndDetailDtoList = topAndDetailDtoList;
    }

    public List<Integer> getMyFavoriteBookIdList() {
        return myFavoriteBookIdList;
    }

    public void setMyFavoriteBookIdList(List<Integer> myFavoriteBookIdList) {
        this.myFavoriteBookIdList = myFavoriteBookIdList;
    }

    public List<Integer> getMyLendedBookIdList() {
        return myLendedBookIdList;
    }

    public void setMyLendedBookIdList(List<Integer> myLendedBookIdList) {
        this.myLendedBookIdList = myLendedBookIdList;
    }

    public List<BK_T_NewsReadDto> getReadStatusNews() {
        return readStatus;
    }

    public void setReadStatusNews(List<BK_T_NewsReadDto> readStatus) {
        this.readStatus = readStatus;
    }

    public List<BK_T_LendDto> getLendNewsList() {
        return lendNewsList;
    }

    public void setLendNewsList(List<BK_T_LendDto> lendNewsList) {
        this.lendNewsList = lendNewsList;
    }

    // 貸出数を取得
    public int getCountMyLendingBookList() {
        return lendNewsList.size();
    }

    public List<V_MyLendHistoryDto> getMyLendingBookList() {
        return myLendingBookList;
    }

    public void setMyLendingBookList(List<V_MyLendHistoryDto> myLendingBookList) {
        this.myLendingBookList = myLendingBookList;
    }

}
