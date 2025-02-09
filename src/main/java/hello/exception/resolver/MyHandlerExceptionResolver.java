package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        try {
            if (e instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
                return new ModelAndView();
            }
        } catch (IOException ex) {
            log.error("Resolver Exception", ex);
        }

        return null;
    }
}
