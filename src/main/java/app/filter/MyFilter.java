package app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/start-servlet"})

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Важно! Установка кодировки.
        //Была проблема: при отправки формы русские буквы становились кракозябрами.
        //Устанавливать кодировку для реквеста необходимо ДО того момента как с ним
        //происходят манипуляции (вытягивание параметров и прочее).
        //т.к. после хотя бы одной манипуляции весь реквест будет распарсен внутренней, неизвестной кодировкой.
        //В данном проекте первое место, где встречается реквест это в этом классе,
        //поэтому тут мы вручную и устанавливаем нужную кодировку UTF-8
        servletRequest.setCharacterEncoding("UTF-8");



        String password = servletRequest.getParameter("password");

        if (password != null) {
            if (!password.equals("mellon")) {
                servletRequest.setAttribute("errMsg", "You entered the wrong administrator password");
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("errorPage.jsp");
                requestDispatcher.forward(servletRequest, servletResponse);
            } else {
                if (servletRequest instanceof HttpServletRequest) {
                    boolean isAdmin = true;
                    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
                    session.setAttribute("isAdmin", isAdmin);
                }
                // filterChain.doFilter - вызываем следующий фильтр в цепочке В ТОМ ЧИСЛЕ И СИСТЕМНЫЕ!
                // Его нужно прописывать всегда, т.к. если не прописать системные фильтры не запустятся и приложение не заработает
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        // Filter.super.destroy();
    }
}
