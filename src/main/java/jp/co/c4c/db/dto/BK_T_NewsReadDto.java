package jp.co.c4c.db.dto;

import java.util.Date;

public class BK_T_NewsReadDto {

    private int memId;
    private Date readAt;
    /**
     * @return memId
     */
    public int getMemId() {
        return memId;
    }
    /**
     * @param memId セットする memId
     */
    public void setMemId(int memId) {
        this.memId = memId;
    }
    /**
     * @return readAt
     */
    public Date getReadAt() {
        return readAt;
    }
    /**
     * @param readAt セットする readAt
     */
    public void setReadAt(Date readAt) {
        this.readAt = readAt;
    }

}