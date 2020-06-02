package com.sylpi.dbmapping.service;

import com.sylpi.dbmapping.dao.InstructorDetailRepository;
import com.sylpi.dbmapping.dao.InstructorRepository;
import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    public InstructorRepository instructorRepository;

    @Autowired
    public InstructorDetailRepository instructorDetailRepository;

    @Override
    public void run(String... args) throws Exception {

        this.instructorRepository.deleteAll();

        Instructor mike = new Instructor("Mike", "Myers", "mike@mail.com");
        Instructor john = new Instructor("John", "Doe", "john@mail.com");


        InstructorDetail mikeDetail = new InstructorDetail("http://youtubechannle1", "random hobby mike");
        InstructorDetail johnDetail = new InstructorDetail("http://youtubechannle1", "random hobby john");

        mike.setInstructorDetail(mikeDetail);
        john.setInstructorDetail(johnDetail);

        List<Instructor> instructors = Arrays.asList(mike, john);
        instructorRepository.saveAll(instructors);
    }
}
