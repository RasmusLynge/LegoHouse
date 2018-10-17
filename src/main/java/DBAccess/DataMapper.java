package DBAccess;

import FunctionLayer.GeneralException;
import FunctionLayer.HouseOrder;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The purpose of UserMapper is to...
 *
 * @author Rasmu
 */
public class DataMapper {

    public static void createUser(User user) throws GeneralException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            String id = ids.getString(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws GeneralException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                String id = rs.getString("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new GeneralException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static void createOrder(int id, HouseOrder hOrder) throws GeneralException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO house_order (user_Id, hLength, hWidth, hHeight, windowDoor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, hOrder.getLenght());
            ps.setInt(3, hOrder.getWidth());
            ps.setInt(4, hOrder.getHeight());
            ps.setBoolean(5, hOrder.isWindowDoor());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
//            String id = ids.getString( 1 );
//            order.setId( id );

        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static ArrayList<HouseOrder> showCustomerOrders(String userId) throws GeneralException {
        ArrayList<HouseOrder> hOrderList = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT idOrder, hLength, hWidth, hHeight, windowDoor, isShipped "
                    + "FROM `house_order`"
                    + "WHERE user_Id=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int hLength = rs.getInt("hLength");
                int hWidth = rs.getInt("hWidth");
                int hHeight = rs.getInt("hHeight");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");

                hOrderList.add(new HouseOrder(idOrder, hLength, hWidth, hHeight, windowDoor, isShipped));
            }
            return hOrderList;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static ArrayList<HouseOrder> showAllOrders() throws GeneralException {
        ArrayList<HouseOrder> hOrderList = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT idOrder, hLength, hWidth, hHeight, windowDoor, isShipped "
                    + "FROM `house_order`;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int hLength = rs.getInt("hLength");
                int hWidth = rs.getInt("hWidth");
                int hHeight = rs.getInt("hHeight");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");
                HouseOrder hOrder = new HouseOrder(idOrder, hLength, hWidth, hHeight, windowDoor, isShipped);
                hOrderList.add(hOrder);
                
            }
            return hOrderList;
//            } else {
//                throw new GeneralException( "Could not validate user" );
//            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static HouseOrder showSingleOrder(int orderId) throws GeneralException {
            
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT *"
                    + "FROM `house_order`"
                    + "WHERE idOrder=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, (orderId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int hLength = rs.getInt("hLength");
                int hWidth = rs.getInt("hWidth");
                int hHeight = rs.getInt("hHeight");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");
                
                HouseOrder singleOrder = new HouseOrder(orderId, hLength, hWidth, hHeight, windowDoor, isShipped);
            
                return singleOrder;
            } else {
                throw new GeneralException("Could not validate user");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }

    }

}
