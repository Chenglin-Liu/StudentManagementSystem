
import dao.inter.StudentDao;
import dao.impl.StudentDaoImpl;
import bean.Student;
import java.util.List;

public class ConnTest {
    public static void main(String[] args){
        String sql = "select * from Student";
        List<Object> empty = null;

        StudentDao stuDao = new StudentDaoImpl();
        List<Student> stu =  stuDao.getStudentList(sql, empty);

        System.out.println("Student's name is " + stu.get(0).getName());
    }
}
