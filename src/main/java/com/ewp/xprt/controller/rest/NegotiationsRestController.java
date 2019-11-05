package com.ewp.xprt.controller.rest;

import com.ewp.xprt.model.Student;
import com.ewp.xprt.service.hh.*;
import com.ewp.xprt.service.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "rest/negotiations")
public class NegotiationsRestController {
    private static Logger logger = LoggerFactory.getLogger(NegotiationsRestController.class);

    private StudentService studentService;
    private HhNegotiationsService hhNegotiationsService;

    @Autowired
    public NegotiationsRestController(StudentService studentService, HhNegotiationsService hhNegotiationsService) {
        this.studentService = studentService;
        this.hhNegotiationsService = hhNegotiationsService;
    }

    @PostMapping(value = "/{student_id}", produces = "application/json")
    public HttpStatus getNegotiation(@PathVariable Long student_id,
                                     @RequestParam(name = "vacId") String vacId,
                                     @RequestParam(name = "message") String message) {

        Student student = studentService.get(student_id); //Ищем студента
        //TODO добавить обработку поля message
        String location = hhNegotiationsService.negotiateOnVacancy(student, vacId, "Тестовый отклик. Настраиваю работу с API hh.ru. Извините за отнятое время");
        if (location != null) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}
