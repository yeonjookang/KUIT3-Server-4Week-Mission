package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View{
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(createModel(request)));
    }

    private Map<String,Object> createModel(HttpServletRequest request) {
        //댓글 작성 버튼을 누르면 요청으로 들어온 데이터를 바로 json 형식으로 응답
        Enumeration<String> names = request.getAttributeNames();
        Map<String, Object> model = new HashMap<>();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            model.put(name,request.getAttribute(name));
        }
        return model;
    }
}
