package com.sylpi.dbmapping.service;

import com.sylpi.dbmapping.dao.InstructorDetailRepository;
import com.sylpi.dbmapping.dao.InstructorRepository;
import com.sylpi.dbmapping.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    public InstructorRepository instructorRepository;
    @Autowired
    public InstructorDetailRepository instructorDetailRepository;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int theId) {
        Optional<Instructor> instructor = instructorRepository.findById(theId);
        Instructor theInstructor = null;
        if (instructor.isPresent()){
            theInstructor = instructor.get();
        }else{
            // didn't find article
            throw new RuntimeException("didn't find instructor with id " + theId);
        }
        return theInstructor;

    }

    @Override
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(int theId) {
        instructorRepository.deleteById(theId);
    }

//    delete instructorDetail from instructor
//    @Override
//    public void deleteInstructorDetail(int id) {
//        instructorDetailRepository.deleteById(id);
//    }
}
