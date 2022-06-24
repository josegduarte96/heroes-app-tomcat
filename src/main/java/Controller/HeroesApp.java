
package Controller;

import Model.Heroe;
import Model.ModelHC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author joseg
 */
@WebServlet(name = "HeroesApp", urlPatterns = {"/heroes"})
public class HeroesApp extends HttpServlet {
    
    private final String URI_LIST = "heroes.jsp";
    private ModelHC model = new ModelHC();
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listaHeroes", model.getHeroes());
        request.setAttribute("listadoNuevosHeroes", heroesParaAgregar());
        request.getRequestDispatcher(URI_LIST).forward(request, response);
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Heroe h;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "add":
                h = new Heroe(request.getParameter("idHeroe"));                
                heroSegunParams(h, request);
                model.addHeroe(h);
                request.setAttribute("listadoNuevoHeroes", heroesParaAgregar());
                break;
            case "update":
                updateHeroe(request);                
                break;
            case "delete":
                deleteHeroe(request);
                request.setAttribute("listadoNuevoHeroes", heroesParaAgregar());
                break;
        }       
        doGet(request, response);
    }
    
    private void heroSegunParams(Heroe hero, HttpServletRequest request) {
        hero.setSuperhero(request.getParameter("nombreHeroe"));
        hero.setPublisher(request.getParameter("editor"));
        hero.setAlter_ego(request.getParameter("nombrePersona"));
        hero.setFirst_appearance(request.getParameter("firstAp"));
    }
    
    private void updateHeroe(HttpServletRequest request){
        Heroe h = model.getHeroe(request.getParameter("id"));
        heroSegunParams(h, request);
        model.updateHeroe(h);
    }
    
    private void deleteHeroe(HttpServletRequest request){
        model.removeHeroe(request.getParameter("id"));
    }
    
    private List<String> heroesParaAgregar(){
        return model.getListadoDisponible();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
