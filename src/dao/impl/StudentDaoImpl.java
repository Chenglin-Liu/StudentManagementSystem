package dao.impl;

import bean.Student;
import dao.inter.StudentDao;

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
            PreparedStatement ps = conn.prepareStatement(sql);

            if (param != null && param.size() > 0){
                for (int i = 0; i < param.size(); i++){
                    ps.setObject(i+1, param.get(i));
                }
            }

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                // create student object
                Student student = new Student();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
