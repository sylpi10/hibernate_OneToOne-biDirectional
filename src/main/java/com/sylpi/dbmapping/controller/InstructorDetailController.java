package com.sylpi.dbmapping.controller;

import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import com.sylpi.dbmapping.service.InstructorDetailService;
import com.sylpi.dbmapping.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detail")
public class InstructorDetailController {

    @Autowired
    public InstructorDetailService instructorDetailService;

    @GetMapping("all")
    public List<InstructorDetail> getAll(){

        List<InstructorDetail> instructorDetails = instructorDetailService.findAll();
        return instructorDetails;
    }

    @GetMapping("/byId/{id}")
    public InstructorDetail instructorDetail(@PathVariable int id){
        InstructorDetail instructorDetail = instructorDetailService.findById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);

        if (instructorDetail == null){
            throw new RuntimeException("no result");
        }
        return instructorDetail;
    }

    @PostMapping("/")
    public InstructorDetail save(@RequestBody InstructorDetail instructorDetail) {
        instructorDetail.setId(0);

        instructorDetailService.save(instructorDetail);
        return instructorDetail;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        InstructorDetail toBeDeleted = instructorDetailService.findById(id);
        if (toBeDeleted == null){
            throw new RuntimeException("no result");
        }
        instructorDetailService.deleteById(id);
        return "deleted instructorDetail with id " + id;
    }

}
