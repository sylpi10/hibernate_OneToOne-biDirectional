package com.sylpi.dbmapping.dao;

import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

//    Instructor deleteInstructorDetailById(int id);
}
