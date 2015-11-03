
package bammt;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
/**
 * Copyright (c) Betsey McCarthy, Mitchell Thompson
 * 
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String url = "/index.jsp";

    // get current action
    String action = request.getParameter("action");

    // print action value to console AND log file
    System.out.println("CalculatorServlet action: " + action);
    log("action=" + action);

    // set default action
    if (action == null) {
      action = "calculate"; 
    }

    if (action.equals("calculate")) {
      url = "/result.jsp";
      double investment = Double.parseDouble(request.getParameter("investment"));
      double rate = Double.parseDouble(request.getParameter("rate"));
      int years = Integer.parseInt(request.getParameter("years"));
      double result = investment * Math.pow(((1 + ((rate)/100))), years);
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String investFormat = (formatter.format(investment));
      request.setAttribute("investment", investFormat);
      request.setAttribute("rate", rate);
      request.setAttribute("years", years);
      String resultFormat = (formatter.format(result));
      request.setAttribute("result", resultFormat);
    } 
    
    getServletContext();
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }
  
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Does investment calculation and returns it to result page";
    }
}
