package org.example.question.question.controller;

import lombok.RequiredArgsConstructor;
import org.example.question.question.entity.Question;
import org.example.question.question.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
}
