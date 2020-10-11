package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * トップ画面 Formクラス
 */
public class TopForm {

    List<V_TopAndDetailDto> topAndDetailDtoList;
    BK_T_NewsReadDto bK_T_NewsReadDto;
    List<Integer> myFavoriteBookIdList;
    List<Integer> myLendedBookIdList;
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

    public BK_T_NewsReadDto getBK_T_NewsReadDto() {
        return bK_T_NewsReadDto;
    }

    public void setBK_T_NewsReadDto(BK_T_NewsReadDto bK_T_NewsReadDto) {
        this.bK_T_NewsReadDto = bK_T_NewsReadDto;
    }

    public List<V_MyLendHistoryDto> getMyLendingBookList() {
        return myLendingBookList;
    }

    public void setMyLendingBookList(List<V_MyLendHistoryDto> myLendingBookList) {
        this.myLendingBookList = myLendingBookList;
    }

}
