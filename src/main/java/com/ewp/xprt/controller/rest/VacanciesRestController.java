package com.ewp.xprt.controller.rest;

import com.ewp.xprt.model.Student;
import com.ewp.xprt.service.hh.*;
import com.ewp.xprt.service.interfaces.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/vacancies")
public class VacanciesRestController {

    private HHOauthService hhoAuthService;
    private OAuth20Service service;
    private ClientAccessTokenService clientAccessTokenService;
    private StudentService studentService;
    private HhDictionaryService hhDictionaryService;
    private HhCvService hhCvService;
    private HhVacancyService hhVacancyService;
    private HhNegotiationsService hhNegotiationsService;
    private CourseService courseService;
    private UserService userService;
    private RoleService roleService;

    public VacanciesRestController(HHOauthService hhoAuthService, ClientAccessTokenService clientAccessTokenService, StudentService studentService, HhDictionaryService hhDictionaryService, HhCvService hhCvService, HhVacancyService hhVacancyService, HhNegotiationsService hhNegotiationsService, CourseService courseService, UserService userService, RoleService roleService) {
        this.hhoAuthService = hhoAuthService;
        this.service = hhoAuthService.getService();
        this.clientAccessTokenService = clientAccessTokenService;
        this.studentService = studentService;
        this.hhDictionaryService = hhDictionaryService;
        this.hhCvService = hhCvService;
        this.hhVacancyService = hhVacancyService;
        this.hhNegotiationsService = hhNegotiationsService;
        this.courseService = courseService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/{student_id}")
    public String getVacancies(@PathVariable Long student_id, @RequestParam int page) {
        Student student = studentService.get(student_id); //Ищем студента

        String vacancies = hhVacancyService.getVacancies(student, page); //Получаем вакансии. Первые 100
//        String vacancies = hhVacancyService.getSimilarVacancies(student, page); //Получаем вакансии. Первые 100
        return vacancies;
    }


}
