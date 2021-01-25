package dao.impl;

import bean.Student;
import dao.inter.StudentDao;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.LinkedList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import tools.MysqlTool;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getStudentList(String sql, List<Object> param) {
        List<Student> list = new LinkedList<>();

        try {
            Connection conn = MysqlTool.connectToDB();
            PreparedStatement ps = conn.prepareStatement(sql);  // use PreparedStatement to avoid SQL inject attack

            if (param != null && param.size() > 0){
                for (int i = 0; i < param.size(); i++){
                    ps.setObject(i+1, param.get(i));
                }
            }

            // execute SQL statement
            ResultSet rs = ps.executeQuery();
            // get metadata
            ResultSetMetaData meta = rs.getMetaData();

            // copy data to Student instance
            while(rs.next()){
                Student student = new Student();

                for (int i = 1; i <= meta.getColumnCount(); i++){
                    String field = meta.getColumnName(i);
                    BeanUtils.setProperty(student, field, rs.getObject(field));
                }
                // ****** TO ADD STREAM ********
                list.add(student);
            }
            // close MySQL Connection, Statement and Result Set
            MysqlTool.close(conn);
            MysqlTool.close(ps);
            MysqlTool.close(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
