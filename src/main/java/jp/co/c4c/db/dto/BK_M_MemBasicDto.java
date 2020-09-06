package jp.co.c4c.db.dto;

import java.util.Date;

import jp.sf.amateras.mirage.annotation.Column;
import jp.sf.amateras.mirage.annotation.Table;

@Table(name = "M_MEM_BASIC")
public class BK_M_MemBasicDto {

    /** メンバーID */
    @Column(name = "MEM_ID")
    private int memId;
    /** メンバー名 */
    @Column(name = "MEM_NAME")
    private String memName;
    /** 削除フラグ */
    @Column(name = "DEL_FLG")
    private int delFlg;
    /** データ作成日時 */
    @Column(name = "CREATE_AT")
    private Date createAt;
    /** データ更新日時 */
    @Column(name = "UPDATE_AT")
    private Date updateAt;

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
     * 削除フラグを取得する
     * @return delFlg
     */
    public int getDelFlg() {
        return delFlg;
    }

    /**
     * 削除フラグを設定する
     * @param delFlg
     */
    public void setDelFlg(int delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * データ作成日時を取得する
     * @return createAt
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * データ作成日時を設定する
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * データ更新日時を取得する
     * @return updateAt
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * データ更新日時を設定する
     * @param updateAt
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}
