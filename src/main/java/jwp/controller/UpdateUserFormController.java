package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.modelandview.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String,String> params) {
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        ModelAndView mv;

        if (user != null) {
            mv = jspView("/user/updateForm.jsp");
            mv.addModel("user", user);
        }
        else
            mv = jspView(REDIRECT + "/");

        return mv;
    }
}