package com.kckj.student.service;

import com.kckj.student.domain.Student;

public class StudentService {
    private Student[] students;
    private int studentNums=1;
    private int idCounter=1;

    public StudentService(int size) {
        students = new Student[size];
        students[0] = new Student(1, "张三", "男", "软件工程", "13800138001", "在组");
    }

    public boolean add(Student newStudent) {
        if (studentNums == students.length) {
            System.out.println("数组已满,无法添加学生");
            return false;
        }
        students[studentNums++] = newStudent;
        newStudent.setId(++idCounter);
        return true;
    }

    public Student findById(int findId) {
        for (int i = 0; i < studentNums; i++) {
            if (findId == students[i].getId()) {
                return students[i];
            }
        }
        return null;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < studentNums; i++) {
            if (delId == students[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < studentNums - 1; i++) {
            students[i] = students[i + 1];
        }
        students[--studentNums] = null;
        return true;
    }

    public Student[] list() {
        return students;
    }
}
