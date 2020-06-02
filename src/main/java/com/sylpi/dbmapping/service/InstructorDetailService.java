package com.sylpi.dbmapping.service;

import com.sylpi.dbmapping.dao.InstructorDetailRepository;
import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface InstructorDetailService {

    public List<InstructorDetail> findAll();

    public InstructorDetail findById(int theId);

    public void save (InstructorDetail instructorDetail);

    public void deleteById(int theId);

}
