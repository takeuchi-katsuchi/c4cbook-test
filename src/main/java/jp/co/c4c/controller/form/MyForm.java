package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.V_MyPageDto;

/**
 * マイページ画面 Formクラス
 */
public class MyForm {

    /** 読んだ本の数 */
    private String count;
    /** ログインユーザーが予約中の本 */
    private List<V_MyPageDto> myResevedBookList;
    /** ログインユーザーに貸出中の本 */
    private List<V_MyPageDto> myLendingBookList;
    /** ログインユーザーが返却済み（読書済み）の本 */
    private List<V_MyPageDto> myReturnedBookList;

    /**
     * 読んだ本の数
     * @return 読んだ本の数
     */
    public String getCount() {
        return count;
    }

    /**
     * 読んだ本の数
     * @param count 読んだ本の数
     */
    public void setCount(String count) {
        this.count = count;
    }

    public List<V_MyPageDto> getMyResevedBookList() {
        return myResevedBookList;
    }

    public void setMyResevedBookList(List<V_MyPageDto> myResevedBookList) {
        this.myResevedBookList = myResevedBookList;
    }

    public List<V_MyPageDto> getMyLendingBookList() {
        return myLendingBookList;
    }

    public void setMyLendingBookList(List<V_MyPageDto> myLendingBookList) {
        this.myLendingBookList = myLendingBookList;
    }

    public List<V_MyPageDto> getMyReturnedBookList() {
        return myReturnedBookList;
    }

    public void setMyReturnedBookList(List<V_MyPageDto> myReturnedBookList) {
        this.myReturnedBookList = myReturnedBookList;
    }

}
