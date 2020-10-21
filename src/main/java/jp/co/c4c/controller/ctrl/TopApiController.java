package jp.co.c4c.controller.ctrl;

import jp.co.c4c.db.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jp.co.c4c.service.TopService;

import java.util.List;
import java.util.stream.Collectors;

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

    // 並び替え、タグ絞り込みように本のリストを取得
    @RequestMapping(value = "/api/getBookList", method = RequestMethod.GET)
    public ResponseEntity<Object> showBookList(@RequestParam(name = "memId") int memId) {
        ApiResponse<V_TopAndDetailDto> response = new ApiResponse<>();

        List<V_TopAndDetailDto> v_topAndDetailDtoList = topService.getAllBooks();

        // ログインユーザーがお気に入りしている本のリストを取得
        List<V_MyFavoriteBookDto> bk_T_FavoriteDtoList = topService.getFavoriteBooks(memId);
        List<Integer> myFavoriteBookIdList = bk_T_FavoriteDtoList.stream()
                .map(V_MyFavoriteBookDto::getBookId)
                .collect(Collectors.toList());

        // ログインユーザーが読書済みの本のリストを取得を取得
        List<V_LendHistoryDto> bk_T_LendDtoList = topService.getlendedBooks(memId);
        List<Integer> myLendedBookIdList = bk_T_LendDtoList.stream()
                .map(V_LendHistoryDto::getBookId)
                .collect(Collectors.toList());


        response.setStatus("Success");
        response.setDataList(v_topAndDetailDtoList);
        response.setMyFavoriteBookIdList(myFavoriteBookIdList);
        response.setMyLendedBookIdList(myLendedBookIdList);

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }



}
