
import tools.MysqlTool;
import java.sql.Connection;
public class ConnTest {
    public static void main(String[] args){
        Connection conn = MysqlTool.connectToDB();
        System.out.println("finished");
        MysqlTool.close(conn);
        System.out.println("Connection closed");
    }
}
