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
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.service.DetailService;
import jp.sf.amateras.mirage.exception.SQLRuntimeException;


/**
 * @author kobarigenki
 *
 */
@RestController
public class RequestApiController {

}