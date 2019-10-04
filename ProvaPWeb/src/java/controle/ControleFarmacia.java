package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Farmacia;
import negocio.Remedio;

@WebServlet(name = "ControleFarmacia", urlPatterns = {"/ControleFarmacia"})
public class ControleFarmacia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String tipo = "";
            
            HttpSession session = request.getSession();
            
            Farmacia farmacia = (Farmacia) session.getAttribute("farmacia");
            if(farmacia == null) {
                farmacia = new Farmacia();
                session.setAttribute("farmacia", farmacia);
            }
                        
            Remedio remedio = new Remedio();
            remedio.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            remedio.setPreco(Double.parseDouble(request.getParameter("preco")));
            remedio.setQtd(Integer.parseInt(request.getParameter("qtd")));
            
            tipo = request.getParameter("tipo");
            
            if(tipo == "normal") {
                farmacia.getNormais().add(remedio);
            }
            else if(tipo == "naoControlado") {
                farmacia.getNaoControlados().add(remedio);
            }
            else 
                farmacia.getControlados().add(remedio);
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleFarmacia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ControleFarmacia\" method=\"POST\">\n" +
            "           <table>\n" +
            "                <tr>\n" +
            "                    <td>Codigo</td>\n" +
            "                    <td><input type=\"text\" name=\"codigo\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td>Preço</td>\n" +
            "                    <td><input type=\"text\" name=\"preco\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td>Quantidade:</td>\n" +
            "                    <td><input type=\"text\" name=\"qtd\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td>Tipo</td>\n" +
            "                    <td>\n" +
            "                        <select name=\"tipo\">\n" +
            "                            <option value=\"normal\">Normal</option>\n" +
            "                            <option value=\"naoControlado\">Não Controlado</option>\n" +
            "                            <option value=\"controlado\">Controlado</option>\n" +
            "                        </select>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "            </table>\n" +
            "            \n" +
            "            <input type=\"submit\" name=\"button\" value=\"OK\">\n" +
            "        </form>");
            out.println("<h1> Rémedios </h1>");
            out.println("<h1> Normal </h1>");
            out.println("<h1>Item 1: " + farmacia.getNormais().size() + "</h1>");
            out.println("<h1>Item 2: " + farmacia.getControlados().size() + "</h1>");
            out.println("<h1>Item 2.1: " + farmacia.getControlados().get(1).getPreco() + "</h1>");
            out.println("<h1>Item 2.2: " + farmacia.getControlados().get(1).getQtd() + "</h1>");
            out.println("<h1>Item 2.3: " + farmacia.getControlados().get(1).getCodigo() + "</h1>");
            out.println("<h1>Item 3: " + farmacia.getNaoControlados().size() + "</h1>");
            /*
            out.println("<table>\n" +
"                <tr>\n" +
"                    <th>Quantidade</th>\n" +
"                    <th>Codigo</th>\n" +
"                    <th>Preco</th>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Preço</td>\n" +
"                    <td>Preço</td>\n" +
"                    <td>Preço</td>\n" +
"                </tr>\n" +
"            </table>"); */
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
