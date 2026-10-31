package com.kckj.student.view;

import com.kckj.student.domain.Student;
import com.kckj.student.service.StudentService;
import com.kckj.student.utils.Utility;

public class StudentView {
    private boolean loop = true;
    private char key = ' ';
    private StudentService studentService = new StudentService(10);

    public void mainMenu() {
        do {
            System.out.println("\n============科创空间学生管理系统菜单============");
            System.out.println("\t\t\t1 新增成员");
            System.out.println("\t\t\t2 查找成员");
            System.out.println("\t\t\t3 删除成员");
            System.out.println("\t\t\t4 修改成员信息");
            System.out.println("\t\t\t5 成员列表");
            System.out.println("\t\t\t6 退    出");
            System.out.print("请输入您的选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addStudent();
                    break;
                case '2':
                    findStudent();
                    break;
                case '3':
                    delStudent();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listStudents();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }

    public void listStudents() {
        System.out.println("================成员列表================");
        System.out.println("编号\t姓名\t\t性别\t专业\t\t电话\t\t状态(在组/退出)");
        Student[] students = studentService.list();
        for (int i = 0; i < students.length; i++) {
            if(students[i]==null){
                break;
            }
            System.out.println(students[i]);
        }
        System.out.println("==============成员列表显示完毕==============");
    }

    public void addStudent() {
        System.out.println("================添加成员================");
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("性别:");
        String gender = Utility.readString(2);
        System.out.print("专业:");
        String major = Utility.readString(10);
        System.out.print("电话:");
        String phone = Utility.readString(12);
        System.out.println("状态(在组/退出):");
        String state = Utility.readString(4);
        Student newStudent = new Student(0,name,gender,major,phone,state);
        if(studentService.add(newStudent)){
            System.out.println("================添加成员成功================");
        }else {
            System.out.println("================添加成员失败================");
        }
    }

    public void findStudent() {
        System.out.println("================查找成员信息================");
        System.out.print("请输入要查找的成员编号:");
        int findId = Utility.readInt();
        Student student = studentService.findById(findId);
        if(student!=null){
            System.out.println(student);
        }else{
            System.out.println("================查找成员不存在================");
        }
    }

    public void delStudent() {
        System.out.println("================删除成员信息================");
        System.out.print("请输入要删除的成员编号(-1退出):");
        int delId = Utility.readInt();
        if(delId==-1){
            System.out.println("================放弃删除成员信息================");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice=='Y'){
            if(studentService.del(delId)){
                System.out.println("================删除成员成功================");
            }else{
                System.out.println("============成员编号不存在,删除失败============");
            }
        }else {
            System.out.println("================放弃删除成员信息================");
        }
    }

    public void update(){
        System.out.println("============修改成员信息============");
        System.out.println("请输入要修改的成员编号(-1退出):");
        int updateId = Utility.readInt();
        if(updateId==-1){
            System.out.println("============放弃修改成员信息============");
            return;
        }
        Student student = studentService.findById(updateId);
        if(student==null){
            System.out.println("============成员编号不存在============");
            return;
        }
        System.out.println("姓名("+student.getName()+"):");
        String name = Utility.readString(8,"");
        if(!"".equals(name)){
            student.setName(name);
        }
        System.out.println("性别("+student.getGender()+"):");
        String gender = Utility.readString(2,"");
        if(!"".equals(gender)){
            student.setGender(gender);
        }
        System.out.println("专业("+student.getMajor()+"):");
        String major = Utility.readString(10,"");
        if(!"".equals(major)){
            student.setMajor(major);
        }
        System.out.println("电话("+student.getPhone()+"):");
        String phone = Utility.readString(12,"");
        if(!"".equals(phone)){
            student.setPhone(phone);
        }
        System.out.println("状态("+student.getState()+"):");
        String state = Utility.readString(4,"");
        if(!"".equals(state)){
            student.setState(state);
        }
        System.out.println("============修改成员信息成功============");
    }

    public void exit(){
        char c=Utility.readConfirmSelection();
        if(c=='Y'){
            loop = false;
        }
    }
}
