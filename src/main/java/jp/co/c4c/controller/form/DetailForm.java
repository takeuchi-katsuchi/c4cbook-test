package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * 詳細画面 Formクラス
 */
public class DetailForm {

    /** 本詳細 */
    V_TopAndDetailDto v_TopAndDetailDto;
    /** 貸出履歴 */
    List<V_LendHistoryDto> v_LendHistoryDtoList;
    /** お気に入りした人 */
    List<V_FavoriteMemberDto> v_FavoriteMemberDtoList;

    public V_TopAndDetailDto getV_TopAndDetailDto() {
        return v_TopAndDetailDto;
    }

    public void setV_TopAndDetailDto(V_TopAndDetailDto v_TopAndDetailDto) {
        this.v_TopAndDetailDto = v_TopAndDetailDto;
    }

    public List<V_LendHistoryDto> getV_LendHistoryDtoList() {
        return v_LendHistoryDtoList;
    }

    public void setV_LendHistoryDtoList(List<V_LendHistoryDto> v_LendHistoryDtoList) {
        this.v_LendHistoryDtoList = v_LendHistoryDtoList;
    }

    public List<V_FavoriteMemberDto> getV_FavoriteMemberDtoList() {
        return v_FavoriteMemberDtoList;
    }

    public void setV_FavoriteMemberDtoList(List<V_FavoriteMemberDto> v_FavoriteMemberDtoList) {
        this.v_FavoriteMemberDtoList = v_FavoriteMemberDtoList;
    }

}
