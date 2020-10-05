package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * トップ画面 Formクラス
 */
public class TopForm {

    List<V_TopAndDetailDto> topAndDetailDtoList;
    BK_T_NewsReadDto NewsReadStatus;
    List<Integer> myFavoriteBookIdList;
    List<Integer> myLendedBookIdList;

    public List<V_TopAndDetailDto> getTopAndDetailDtoList() {
        return topAndDetailDtoList;
    }

    public void setTopAndDetailDtoList(List<V_TopAndDetailDto> topAndDetailDtoList) {
        this.topAndDetailDtoList = topAndDetailDtoList;
    }


    public BK_T_NewsReadDto getNewsReadStatus() {
        return NewsReadStatus;
    }

    public void setNewsReadStatus(BK_T_NewsReadDto newsReadStatus ) {
        this.NewsReadStatus = newsReadStatus;
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

}
