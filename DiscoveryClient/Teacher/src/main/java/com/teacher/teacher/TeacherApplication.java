package com.teacher.teacher;

import com.teacher.teacher.model.*;
import com.teacher.teacher.model.array.*;
import com.teacher.teacher.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class TeacherApplication {
    @Autowired
    private ScoreService viewScoreService;
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private ViewStudentService viewStudentService;
    @Autowired
    private ViewSubjectService viewSubjectService;
    @Autowired
    private ViewTeacherService viewTeacherService;
    @Autowired
    private SectionCheckerService sectionCheckService;

    public static void main(String[] args) {

        SpringApplication.run(TeacherApplication.class, args);
    }

    //////////////////////////////////////////    Student    ///////////////////////////////////////////
    @RequestMapping(value = "/student/view/{id}", method = RequestMethod.GET)
    Student viewPersoninfo(@PathVariable int id){
        return viewStudentService.getStudent(id);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    StudentList allStudent(){
        return viewStudentService.getAllStudent();
    }
    //////////////////////////////////////////    Student    ///////////////////////////////////////////



    //////////////////////////////////////////    Section    ///////////////////////////////////////////
    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    SectionList getSection(){return viewSectionService.getAllSection();}

    @RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
    Section getSectionByID(@PathVariable String id){return viewSectionService.getSectionByID(id);}
    //////////////////////////////////////////    Section    ///////////////////////////////////////////



    //////////////////////////////////////////    Subject    ///////////////////////////////////////////
    @RequestMapping(value = "/subject/view/{id}", method = RequestMethod.GET)
    Subject viewSubjectdemo(@PathVariable int id){ return viewSubjectService.getSubject(id); }
    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    SubjectList getAllSubject(){return viewSubjectService.getAllSubject();}
    //////////////////////////////////////////    Subject    ///////////////////////////////////////////



    //////////////////////////////////////////    Score    ///////////////////////////////////////////
    @RequestMapping(value = "/scores/create", method = RequestMethod.POST)
    ScoresList createScores(@RequestBody ScoresList scores){ return viewScoreService.createScores(scores); }

    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    ScoresList allScores(){
        return viewScoreService.getAllScores();
    }

    @RequestMapping(value = "/scores/{id}", method = RequestMethod.GET)
    Scores getScoresByID(@PathVariable int id){ return viewScoreService.getScoresByID(id); }

    @RequestMapping(value = "/scores/update/{id}", method = RequestMethod.POST)
    Scores updateScoresByID(@RequestBody Scores scores,@PathVariable int id){ return viewScoreService.updateScores(scores,id); }

    @RequestMapping(value = "/scores/delete/{id}", method = RequestMethod.GET)
    Boolean scoresDeleteByID(@PathVariable int id){
        return viewScoreService.deleteScoresByID(id);
    }
    //////////////////////////////////////////    Score    ///////////////////////////////////////////



    //////////////////////////////////////////    SectionCheck    ///////////////////////////////////////////
    @RequestMapping(value = "/sectionCheck/create", method = RequestMethod.POST)
    SectionCheckArray createSectionCheck(@RequestBody SectionCheckArray check){return sectionCheckService.createSection(check);}

    @RequestMapping(value = "/sectionCheck", method = RequestMethod.GET)
    SectionCheckArray getAllSectionCheck(){return sectionCheckService.getAllSectionCheck();}

    @RequestMapping(value = "/sectionCheck/{id}", method = RequestMethod.GET)
    SectionChecked getSectionChecktByID(@PathVariable int id){return sectionCheckService.getSectionChecktByID(id);}

    @RequestMapping(value = "/sectionCheck/update/{id}", method = RequestMethod.POST)
    SectionChecked updateSubjectByid(@RequestBody SectionChecked s, @PathVariable int id){return sectionCheckService.updateSectionCheck(s,id);}

    @RequestMapping(value = "/sectionCheck/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSectionCheck(@PathVariable int id){return sectionCheckService.deleteSectionCheckByID(id);}
    //////////////////////////////////////////    SectionCheck    ///////////////////////////////////////////
}
