package com.sylpi.dbmapping.service;

import com.sylpi.dbmapping.entity.Instructor;

import java.util.List;

public interface InstructorService {

    public List<Instructor> findAll();

    public Instructor findById(int theId);

    public void save (Instructor instructor);

    public void deleteById(int theId);

    // delete instructor detail passing by instructor
//    public void deleteInstructorDetail(int id);
}
