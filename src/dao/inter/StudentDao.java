package dao.inter;

import java.util.List;
import bean.Student;

public interface StudentDao {

    public List<Student> getStudentList(String user, String password);
}
