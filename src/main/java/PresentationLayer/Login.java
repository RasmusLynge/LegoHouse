package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.GeneralException;
import FunctionLayer.HouseOrder;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        

        if (user.getRole().equals("employee")) {
            ArrayList<HouseOrder> orders = LogicFacade.showAllOrders();

            session.setAttribute("allOrderList", orders);
            return "employeepage";
        }

        return "customerpage";
    }

}
