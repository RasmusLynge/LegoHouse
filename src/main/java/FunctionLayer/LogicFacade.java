package FunctionLayer;

import DBAccess.DataMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws GeneralException {
        return DataMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws GeneralException {
        User user = new User(email, password, "customer");
        DataMapper.createUser(user);
        return user;
    }

    public static void createOrder(int userId, HouseOrder hOrder) throws GeneralException {
        DataMapper.createOrder(userId, hOrder);
    }

    public static ArrayList<HouseOrder> showCustomerOrders(String userId) throws GeneralException {
        return DataMapper.showCustomerOrders(userId);
    }

    public static ArrayList<HouseOrder> showAllOrders() throws GeneralException {
        return DataMapper.showAllOrders();
    }
    
    public static HouseOrder showSingleOrder(int orderId) throws GeneralException {
        return DataMapper.showSingleOrder(orderId);
        
    }
}
