package jp.co.c4c.controller.form;

import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * 詳細画面 Formクラス
 */
public class DetailForm {

    V_TopAndDetailDto v_TopAndDetailDto;

    public V_TopAndDetailDto getV_TopAndDetailDto() {
        return v_TopAndDetailDto;
    }

    public void setV_TopAndDetailDto(V_TopAndDetailDto v_TopAndDetailDto) {
        this.v_TopAndDetailDto = v_TopAndDetailDto;
    }

}
