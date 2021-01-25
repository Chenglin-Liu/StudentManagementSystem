package dao.inter;

import java.util.List;
import bean.Student;

public interface StudentDao {

    List<Student> getStudentList(String sql, List<Object> param);

}
