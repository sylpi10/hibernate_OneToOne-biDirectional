package com.sylpi.dbmapping.controller;

import com.sylpi.dbmapping.entity.Instructor;
import com.sylpi.dbmapping.entity.InstructorDetail;
import com.sylpi.dbmapping.service.InstructorDetailService;
import com.sylpi.dbmapping.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class InstructorController {

    @Autowired
    public InstructorService instructorService;
    @Autowired
    public InstructorDetailService instructorDetailService;

    @GetMapping("all")
    public List<Instructor> getAll(){

        List<Instructor> instructors = instructorService.findAll();
        return instructors;
    }

    @GetMapping("/byId/{id}")
    public Instructor instructor(@PathVariable int id){
        Instructor instructor = instructorService.findById(id);
        if (instructor == null){
            throw new RuntimeException("no result");
        }
        return instructor;
    }

    @PostMapping("/")
     public Instructor save(@RequestBody Instructor instructor) {
        instructor.setId(0);

        instructorService.save(instructor);
        return instructor;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        Instructor toBeDeleted = instructorService.findById(id);
        if (toBeDeleted == null){
            throw new RuntimeException("no result");
        }
        instructorService.deleteById(id);
        return "deleted instructor with id " + id;
    }

      // delete an instructorDetail passing by instructor
//    @DeleteMapping("/deletedetail/{id}")
//    public String deletedetail(@PathVariable int id){
//        InstructorDetail instructorDetailToDelete = instructorDetailService.findById(id);
//
//        instructorDetailToDelete.getInstructor().setInstructorDetail(null);
//        if (instructorDetailToDelete == null){
//            throw new RuntimeException("no result");
//        }
//        instructorService.deleteInstructorDetail(id);
//
//        return "deleted instructordetail  " + instructorDetailToDelete.toString();
//    }
}
