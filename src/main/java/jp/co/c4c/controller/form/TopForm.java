package jp.co.c4c.controller.form;

import java.util.List;

/**
 * トップ画面 Formクラス
 */
public class TopForm {

    /** 本ID */
    private int bookId;
    /** タイトル */
    private String title;
    /** 著者 */
    private String author;
    /** タグ */
    private String tagIds;
    /** 概要 */
    private String outline;
    /** 画像 */
    private byte[] bookImg;
    /** 貸出ID */
    private int lendId;
    /** メンバーID */
    private int memId;
    /** メンバー名 */
    private String memName;
    /** TopForm List  */
    List<TopForm> topForms;

    /**
     * 本IDを取得する
     * @return bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * 本IDを設定する
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * タイトルを取得する
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定する
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 著者を取得する
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 著者を設定する
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * タグを取得する
     * @return tagIds
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     * タグを設定する
     * @param tagIds
     */
    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    /**
     * 概要を取得する
     * @return outline
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 概要を設定する
     * @param outline
     */
    public void setOutline(String outline) {
        this.outline = outline;
    }

    /**
     * 画像を取得する
     * @return bookImg
     */
    public byte[] getBookImg() {
        return bookImg;
    }

    /**
     * 画像を設定する
     * @param bookImg
     */
    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * 貸出IDを取得する
     * @return lendId
     */
    public int getLendId() {
        return lendId;
    }

    /**
     * 貸出IDを取得する
     * @param lendId
     */
    public void setLendId(int lendId) {
        this.lendId = lendId;
    }

    /**
     * メンバーIDを取得する
     * @return memId
     */
    public int getMemId() {
        return memId;
    }

    /**
     * メンバーIDを設定する
     * @param memId
     */
    public void setMemId(int memId) {
        this.memId = memId;
    }

    /**
     * メンバー名を取得する
     * @return memName
     */
    public String getMemName() {
        return memName;
    }

    /**
     * メンバー名を設定する
     * @param title
     */
    public void setMemName(String memName) {
        this.memName = memName;
    }

    /**
     * TopForm Listを取得する
     * @return
     */
    public List<TopForm> getTopForms() {
        return topForms;
    }

    /**
     * TopForm Listを設定する
     * @return
     */
    public void setTopForms(List<TopForm> topForms) {
        this.topForms = topForms;
    }

}
