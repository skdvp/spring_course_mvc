package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/employee")
/*
если аннотацию указать над самим контроллером,
сервер выдаст 404, но если добавить в адрес то,
что указано в аннотации ("/employee"), тогда всё заработает
*/
public class MyController {

    @GetMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @GetMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(500);


        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }


    @PostMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }

    }


}
