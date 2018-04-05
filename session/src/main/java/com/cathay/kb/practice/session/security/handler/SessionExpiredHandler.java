package com.cathay.kb.practice.session.security.handler;

import com.cathay.kb.practice.session.controller.bean.SessionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionExpiredHandler implements SessionInformationExpiredStrategy {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        response.setContentType("application/json;charset=UTF-8");

        SessionMessage sessionMessage = new SessionMessage();
        sessionMessage.setSessionMsg("Duplicate login");

        response.getOutputStream().println(mapper.writeValueAsString(sessionMessage));
    }
}
