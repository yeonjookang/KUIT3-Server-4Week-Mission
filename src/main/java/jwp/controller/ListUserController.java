package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.modelandview.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {
    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public ModelAndView execute(Map<String,String> params) {
        ModelAndView mv;
        if(UserSessionUtils.isLogined(session)){
            mv = jspView("/user/list.jsp");
            mv.addModel("users", MemoryUserRepository.getInstance().findAll());
        }
        else{
            mv = jspView(REDIRECT + "/user/loginForm");
        }

        return mv;
    }
}
