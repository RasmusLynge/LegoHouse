/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Bricks;
import FunctionLayer.GeneralException;
import FunctionLayer.HouseCalculator;
import FunctionLayer.HouseOrder;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmu
 */
public class HouseSize extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        int houseLength, houseWidth, houseHeight;

        houseLength = Integer.parseInt(request.getParameter("houselength"));
        houseWidth = Integer.parseInt(request.getParameter("housewidth"));
        houseHeight = Integer.parseInt(request.getParameter("househeight"));
        boolean windowDoor = Boolean.valueOf(request.getParameter("windowDoor"));

        HouseOrder houseOrder = new HouseOrder(10, houseLength, houseWidth, houseHeight, windowDoor, false);
        
        HttpSession session = request.getSession();
        session.setAttribute("length", houseLength);
        session.setAttribute("width", houseWidth);
        session.setAttribute("height", houseHeight);
        session.setAttribute("windowDoor", windowDoor);
        User u = (User) request.getSession().getAttribute("user");
        int userId = Integer.parseInt(u.getId());
        
        if (windowDoor == false && houseLength > 5 && houseWidth > 5 && houseHeight > 0) {
            Bricks bricks = HouseCalculator.calculateHouse(houseLength, houseWidth, houseHeight, windowDoor);
            request.getSession().setAttribute("bricks", bricks);
            LogicFacade.createOrder(userId, houseOrder);
            return "orderpage";
        } else if (windowDoor == true && houseLength > 7 && houseWidth > 7 && houseHeight > 4) {
            Bricks x = HouseCalculator.calculateHouse(houseLength, houseWidth, houseHeight, windowDoor);
            request.getSession().setAttribute("bricks", x);
            LogicFacade.createOrder(userId, houseOrder);
            return "orderpage";
        } else {
            throw new GeneralException("This house is too small to be made. Remember to use Integers");
        }
    }
}
