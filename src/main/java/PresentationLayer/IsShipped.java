/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.GeneralException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmu
 */
public class IsShipped extends Command {

    public IsShipped() {
    }
// Dette er ikke implementeret endnu 
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        User user = (User) request.getSession().getAttribute("user");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        
        return user.getRole() + "page";
    }

}
