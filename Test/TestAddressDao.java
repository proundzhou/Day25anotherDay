import com.qf.java1906.zhouzhihao.addressList.Dao.Impl.AddressDaoImpl;
import com.qf.java1906.zhouzhihao.addressList.Entity.Contact;
import com.qf.java1906.zhouzhihao.addressList.Utils.DBClose;
import com.qf.java1906.zhouzhihao.addressList.Utils.DBUtils;
import org.junit.Test;

import java.sql.*;

public class TestAddressDao {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rSet=null;
        int count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("select count(*) from addressList where(password=?)&&(password=?) ");
            ps.setString(1,"admin");
            ps.setString(2,"admin");
            rSet = ps.executeQuery();
            if(rSet.next()){
                count=rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,connection);
        }
        System.out.println(count);
    }

    @Test
    public void testInsertContact(){
        AddressDaoImpl addressDao = new AddressDaoImpl();
        Integer integer = addressDao.insertContact(new Contact("姓名","123456789","地址"));
    }
}
