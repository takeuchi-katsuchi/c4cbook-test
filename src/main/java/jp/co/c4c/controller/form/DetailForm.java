package jp.co.c4c.controller.form;

/**
 * 詳細画面 Formクラス
 */
public class DetailForm {

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
    /** 提供メンバーID */
    private int offerMemId;
    /** 提供メンバーコメント */
    private String offerMemComment;
    /** 貸出ID */
    private int lendId;
    /** メンバーID */
    private int memId;
    /** メンバー名 */
    private String memName;

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
     * 提供メンバーIDを取得する
     * @return offerMemId
     */
    public int getOfferMemId() {
        return offerMemId;
    }

    /**
     * 提供メンバーIDを設定する
     * @param offerMemId
     */
    public void setOfferMemId(int offerMemId) {
        this.offerMemId = offerMemId;
    }

    /**
     * 提供メンバーコメントを取得する
     * @return offerMemComment
     */
    public String getOfferMemComment() {
        return offerMemComment;
    }

    /**
     * 提供メンバーコメントを設定する
     * @param offerMemComment
     */
    public void setOfferMemComment(String offerMemComment) {
        this.offerMemComment = offerMemComment;
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

}
