package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employee")
/*
если аннотацию указать над самим контроллером,
сервер выдаст 404, но если добавить в адрес то,
что указано в аннотации ("/employee"), тогда всё заработает
*/
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }


    @RequestMapping("showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model) {

        empName = "Mr. " + empName + "!!!";
        model.addAttribute("nameAttribute", empName);


        return "show-emp-details-view";
    }


}
