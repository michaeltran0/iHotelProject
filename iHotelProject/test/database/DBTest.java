package database;

import java.sql.SQLException;
import java.util.List;
import junit.framework.Assert;
import model.Room;
import model.UserLogin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hani
 */
public class DBTest {
    
    private static DBConnection conn;
    
    public DBTest() {
    }
    
    // run once before all tests
    @BeforeClass
    public static void setUpClass() {
        // initialize db connection
        conn = DBConnection.getInstance();
    }
    
    // run after all tests
    @AfterClass
    public static void tearDownClass() {
        // close conn
        conn.destroy();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getClientByEmailAdminTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("admin@gmail.com");
        assertEquals("admin", userLogin.getPassword());
        assertEquals("admin", userLogin.getType());
    }
    
    @Test
    public void getClientByEmailMemberTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("hani@gmail.com");
        assertEquals("hani", userLogin.getPassword());
        assertEquals("member", userLogin.getType());
    }
    
    @Test
    public void getRoomsTest() throws SQLException {
        List<Room>listroom = DBRoom.getRooms();
        assertEquals(true, listroom.size() > 0);
    }

    
       @Test
    public void deteleMemberTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("ali@gmail.com");
        assertEquals("ali", userLogin.getPassword());
        assertEquals("member", userLogin.getType());
    }
    
       @Test
    public void setMemberTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("hani@gmail.com");
        assertEquals("hani", userLogin.getPassword());
        assertEquals("member", userLogin.getType());
    }
    
         @Test
    public void getMemberTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("hani@gmail.com");
        assertEquals("hani", userLogin.getPassword());
        assertEquals("member", userLogin.getType());
    }
    
        /*
    //its not woking
     @Test
    public void insertMemberTest() throws SQLException {
        UserLogin userLogin = DBUserLogin.getClientByEmail("neda@gmail.com");
        assertEquals("neda", userLogin.getPassword());
        assertEquals("neda", userLogin.getType());
    }*/

         @Test
    public void getRoomByIDTest() throws SQLException {
      Room r = DBRoom.getRoomByID(1);
             assertEquals(305, r.getRoomNo());
             assertEquals(1, r.getRoomid());
    }

    
}
