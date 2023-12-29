package pkg_person;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager {
    ObjectOutputStream oos_student = null;
    ObjectInputStream ois_student = null;

    File student_file = null;

    ArrayList<Student> student_list = null;
    
    @SuppressWarnings("unchecked")
    public StudentManager(){
        student_file = new File("student.dat");
        student_list = new ArrayList<>();
        try{
            if(student_file.exists()){
                ois_student = new ObjectInputStream(new FileInputStream(student_file));
                student_list = (ArrayList<Student>) ois_student.readObject();
                ois_student.close();
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void addStudent(Student student){
        student_list.add(student);
    }

    public Student get(int rollNo){
        for(Student student:student_list){
            if(student.getRollNo() == rollNo) return student;
        }
        return null;
    }
   
    public void viewAllStudents(){
        for(Student student:student_list){
            System.out.println(student);
        }
    }

    public boolean deleteStudent(int delete_rollNo){
        ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.iterator();
        while(student_iterator.hasNext()){
            Student student = student_iterator.next();
            if(student.getRollNo()==delete_rollNo){
                student_iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateStudent(int upd_rollNo, String name, String emailId , String phoneNumber , String address , String dob, int std , String division){
        ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.iterator();
        while(student_iterator.hasNext()){
            Student student = student_iterator.next();
            if(student.getRollNo()==upd_rollNo){
                student.setName(name);
                student.setEmailId(emailId);
                student.setPhoneNumber(phoneNumber);
                student.setAddress(address);
                student.setDob(dob);
                student.setStd(std);
                student.setDivision(division);
                return true;
            }
        }
        return false;
    }

}
