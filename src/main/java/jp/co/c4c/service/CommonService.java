package jp.co.c4c.service;

import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.WebSessionDto;

@Component
public class CommonService {

    public boolean isLogined(WebSessionDto webSessionDto) throws NullPointerException {

        try {
            Integer memId = webSessionDto.getMemId();
            String sessionId = webSessionDto.getSessionId();
            System.out.println("ログインユーザー: " + memId);
            System.out.println("セッションID: " + sessionId);
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

}
