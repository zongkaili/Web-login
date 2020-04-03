package mvc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zongkl
 * @date 2020/4/2 0002
 * @desc
 */
public class JdbcUtil {

    private static Properties sProperties = new Properties();

    private JdbcUtil() {
    }

    static {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            // 从classpath的根路径去寻找db.properties
            InputStream inStream = loader.getResourceAsStream("resources/db.properties");
            sProperties.load(inStream); //加载
        } catch (IOException e) {
            throw new RuntimeException("加载classpath路径下的db.properties文件失败", e);
        }
        //加载数据库驱动
        try {
            Class.forName(sProperties.getProperty("DriverName"));
            System.out.println("加载数据库驱动正常");
        } catch (Exception e) {
            throw new RuntimeException("数据库驱动加载失败", e);
        }
    }

    //返回创建好的Connection对象
    public static Connection getConn() {
        try {
            System.out.println("连接数据库正常");
            //获取连接对象
            return DriverManager.getConnection(sProperties.getProperty("url"), sProperties.getProperty("username"),
                    sProperties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("数据库连接异常");
    }

    //释放资源
    public static void close(Connection conn, Statement st, ResultSet re) {
        try {
            if (re != null) {
                re.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
