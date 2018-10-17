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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmu
 */
public class ShowSingleOrder extends Command {

    public ShowSingleOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        HouseOrder singleOrder = LogicFacade.showSingleOrder(orderId);

        Bricks bricks = HouseCalculator.calculateHouse(singleOrder.getLenght(), singleOrder.getWidth(), singleOrder.getHeight(), singleOrder.isWindowDoor());
        
        request.getSession().setAttribute("orderId", orderId);
        request.getSession().setAttribute("length", String.valueOf(singleOrder.getLenght()));
        request.getSession().setAttribute("width", String.valueOf(singleOrder.getWidth()));
        request.getSession().setAttribute("height", String.valueOf(singleOrder.getHeight()));
        request.getSession().setAttribute("windowDoor", singleOrder.isWindowDoor());
        request.getSession().setAttribute("bricks", bricks);

        return "orderpage";
    }

}
