package jp.co.c4c.controller.form;

/**
 * マイページ画面 Formクラス
 */
public class MyForm {

    /** 読んだ本の数 */
    private String count;

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

}
