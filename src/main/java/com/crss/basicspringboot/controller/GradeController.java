package com.crss.basicspringboot.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.crss.basicspringboot.model.Grade;
import com.crss.basicspringboot.service.GradeService;

@Controller
public class GradeController {

   GradeService gradeService = new GradeService();

   @GetMapping("/")
   public String getForm(Model model, @RequestParam(required = false) String id) {
      model.addAttribute("grade", gradeService.getGradeById(id));
      return "form";
   }

   @PostMapping("/handleSubmit")
   public String submitForm(@Valid Grade grade, BindingResult result) {
      if (result.hasErrors())
         return "form";

      gradeService.submitForm(grade);
      return "redirect:/grades";
   }

   @GetMapping("/grades")
   public String getGrades(Model model) {
      model.addAttribute("grades", gradeService.getGrades());
      return "grades";
   }
}
