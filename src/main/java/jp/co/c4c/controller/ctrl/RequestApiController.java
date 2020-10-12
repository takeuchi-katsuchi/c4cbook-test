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
import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.db.dto.BK_T_RequestCheerDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.service.DetailService;
import jp.co.c4c.service.RequestService;
import jp.sf.amateras.mirage.exception.SQLRuntimeException;


/**
 * @author kobarigenki
 *
 */
@RestController
public class RequestApiController {

    @Autowired
    RequestService requestService;

    /**
     * 新しい本の要望
     * @param bK_T_RequestDto
     * @return
     */
    @RequestMapping(value = "/api/requestBook", method = RequestMethod.POST)
    public ResponseEntity<Object> requestBook(@RequestBody BK_T_RequestDto bK_T_RequestDto) {
        System.out.println(bK_T_RequestDto.toString()); //確認用

        ApiResponse<BK_T_RequestDto> response = new ApiResponse<>("sucess", bK_T_RequestDto);
        requestService.saveRequestBook(bK_T_RequestDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * 本の応援を登録
     * @param bk_T_LendDto
     * @return
     */
    @RequestMapping(value = "/api/cheerBook", method = RequestMethod.POST)
    public ResponseEntity<Object> cheerBook(@RequestBody BK_T_RequestCheerDto bK_T_RequestCheerDto) {
        System.out.println(bK_T_RequestCheerDto.toString()); //確認用

        ApiResponse<BK_T_RequestCheerDto> response = new ApiResponse<>("sucess", bK_T_RequestCheerDto);
        requestService.saveCheerCount(bK_T_RequestCheerDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}