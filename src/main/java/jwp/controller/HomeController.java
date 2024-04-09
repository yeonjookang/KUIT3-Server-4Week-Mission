package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.modelandview.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HomeController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(Map<String,String> params) {
        JspView view = new JspView("/home.jsp");
        ModelAndView mv = new ModelAndView(view);

        mv.addModel("questions", questionRepository.findAll());
        return mv;
    }
}
