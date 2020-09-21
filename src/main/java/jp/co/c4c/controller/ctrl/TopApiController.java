package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.service.TopService;

/**
 * @author takayukiyamaoka
 *
 */
@RestController
public class TopApiController {

    @Autowired
    TopService topService;

    /**
     * お気に入り登録
     * @param bk_T_FavoriteDto
     * @return
     */
    @RequestMapping(value = "/api/favorite", method = RequestMethod.POST)
    public ResponseEntity<Object> saveMyFavoriteBook(@RequestBody  BK_T_FavoriteDto bk_T_FavoriteDto) {
        ApiResponse<BK_T_FavoriteDto> response = new ApiResponse<>();

        topService.saveMyFavoriteBook(bk_T_FavoriteDto);

        response.setStatus("お気に入り登録しました。");
        response.setData(bk_T_FavoriteDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/favorite-delete", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteMyFavoriteBook(@RequestBody  BK_T_FavoriteDto bk_T_FavoriteDto) {
        ApiResponse<BK_T_FavoriteDto> response = new ApiResponse<>();

        topService.deleteMyFavoriteBook(bk_T_FavoriteDto);

        response.setStatus("お気に入りを削除しました。");
        response.setData(bk_T_FavoriteDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
