/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bammt;

/**
 *
 * @author emccarthy3
 */
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class CurrencyFormatTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.LONG);
        
        CalculatorServlet calculator = (CalculatorServlet) pageContext.findAttribute("calculator");
        calculator.getAttribute("investment");


        try {
            JspWriter out = pageContext.getOut();
            out.print(currentDateFormatted);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}