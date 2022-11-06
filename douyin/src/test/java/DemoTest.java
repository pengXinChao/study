import org.junit.Test;

/**
 * @author 彭心潮
 * @date 2022/11/3 17:01
 */
public class DemoTest {

    @Test
    public void generatorDeleteSQL() {
        int start = 10604143;
        int end = 24050001;

        while (start < end) {
            int sqlEnd = start + 99999;
            if (sqlEnd > end) {
                sqlEnd = end;
            }
            System.out.println("delete from t_order_interface_log where id >= " + start + " and id <= " + sqlEnd + " and is_valid = '0';");
            start = sqlEnd + 1;
        }
    }
}
