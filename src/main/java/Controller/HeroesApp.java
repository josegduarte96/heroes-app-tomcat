package Controller;

import Model.Heroe;
import Model.ModelMySQL;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joseg
 */
@WebServlet(name = "HeroesApp", urlPatterns = {"/heroes"})
public class HeroesApp extends HttpServlet {

    private final String URI_LIST = "heroes.jsp";
    private final String URI_DELETE = "eliminarHeroe.jsp";
    private final String URI_WATCH_HEROE = "editHeroe.jsp";
    private ModelMySQL model = new ModelMySQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        int idHeroe = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        HttpSession httpSession = request.getSession();
        switch (accion) {
            case "watch":
                httpSession.setAttribute("heroe", model.getHeroe(idHeroe));
                response.sendRedirect(URI_WATCH_HEROE);
                break;
            case "remove":
                httpSession.setAttribute("heroe", model.getHeroe(idHeroe));
                response.sendRedirect(URI_DELETE);
                break;
            case "filterDc":
                httpSession.setAttribute("listaHeroes", model.getHeroesByPublisher("Dc Comics"));
                response.sendRedirect(URI_LIST);
                break;
            case "filterMarvel":
                httpSession.setAttribute("listaHeroes", model.getHeroesByPublisher("Marvel Comics"));
                response.sendRedirect(URI_LIST);
                break;
            default:
                httpSession.setAttribute("listaHeroes", model.getHeroes());
                response.sendRedirect(URI_LIST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHeroe = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "add":
                Heroe h = new Heroe();
                heroSegunParams(h, request);
                model.addHeroe(h);
                break;
            case "update":
                updateHeroe(request, idHeroe);
                break;
            case "delete":
                deleteHeroe(request, idHeroe);
                break;
        }
        doGet(request, response);
    }

    private void heroSegunParams(Heroe hero, HttpServletRequest request) {
        hero.setSuperhero(request.getParameter("nombreHeroe"));
        hero.setPublisher(request.getParameter("editor"));
        hero.setAlter_ego(request.getParameter("nombrePersona"));
        hero.setFirst_appearance(request.getParameter("firstAp"));
        hero.setCharacters(request.getParameter("characters"));
        hero.setFoto(request.getParameter("fotoBase64"));
    }

    private void updateHeroe(HttpServletRequest request, int id) {
        Heroe h = model.getHeroe(id);
        heroSegunParams(h, request);
        model.updateHeroe(h);
    }

    private void deleteHeroe(HttpServletRequest request, int id) {
        model.removeHeroe(id);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
