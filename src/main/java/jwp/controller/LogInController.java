package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.modelandview.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController extends AbstractController {
    HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @Override
    public ModelAndView execute(Map<String,String> params) {
        String userId = params.get("userId");
        String password = params.get("password");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        ModelAndView mv;

        if (user != null && user.isSameUser(userId, password)) {
            session.setAttribute("user", user);
            mv = jspView(REDIRECT + "/");
        }
        else
            mv = jspView(REDIRECT + "/user/loginFailed");

        return mv;
    }
}