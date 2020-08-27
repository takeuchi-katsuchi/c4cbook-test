package jp.co.c4c.controller.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.service.DetailService;

@RestController
public class DetailApiController {

    @Autowired
    DetailService detailService;

    @RequestMapping(value = "/api/proceedLendReserve", method = RequestMethod.POST)
    public ResponseEntity<Object> lendReserveBook(@RequestBody BK_T_LendDto bk_T_LendDto){
        System.out.println(bk_T_LendDto.toString()); //確認用

        ApiResponse<BK_T_LendDto> response = new ApiResponse<>("sucess", bk_T_LendDto);
        detailService.saveLendBook(bk_T_LendDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getLendHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> getLendHistory (@RequestParam("bookId") int bookId){
        DetailForm detailForm = new DetailForm();
        detailForm.setV_LendHistoryDtoList(detailService.getLendHistorysById(bookId));

        ApiResponse<List<V_LendHistoryDto>> response = new ApiResponse<>("sucess", detailForm.getV_LendHistoryDtoList());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
