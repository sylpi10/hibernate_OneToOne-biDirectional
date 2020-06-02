package com.sylpi.dbmapping.service;

import com.sylpi.dbmapping.dao.InstructorDetailRepository;
import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService{

    @Autowired
    public InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailService instructorDetailService;

    @Override
    public List<InstructorDetail> findAll() {
        return instructorDetailRepository.findAll();
    }

    @Override
    public InstructorDetail findById(int theId) {
        Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(theId);
        InstructorDetail theInstructorDetail = null;
        if (instructorDetail.isPresent()){
            theInstructorDetail = instructorDetail.get();
        }else{
            // didn't find article
            throw new RuntimeException("didn't find instructor with id " + theId);
        }
        return theInstructorDetail;

    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public void deleteById(int theId) {
        InstructorDetail instructorDetailToDelete = instructorDetailService.findById(theId);

        instructorDetailToDelete.getInstructor().setInstructorDetail(null);

        instructorDetailRepository.deleteById(theId);
    }
}
