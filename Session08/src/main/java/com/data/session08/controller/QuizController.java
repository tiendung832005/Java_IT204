package com.data.session08.controller;

import com.data.session08.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class QuizController {

    private List<Question> questions = new ArrayList<>();
    private Question currentQuestion;
    private int attempts = 0;

    public QuizController() {
        questions.add(new Question() {{
            setId(1);
            setImageUrl("/images/question1.jpg");
            setAnswer("apple");
        }});
        questions.add(new Question() {{
            setId(2);
            setImageUrl("/images/question2.jpg");
            setAnswer("banana");
        }});
        questions.add(new Question() {{
            setId(3);
            setImageUrl("/images/question3.jpg");
            setAnswer("cherry");
        }});
    }

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        Random random = new Random();
        currentQuestion = questions.get(random.nextInt(questions.size()));
        attempts = 0;
        model.addAttribute("question", currentQuestion);
        model.addAttribute("message", "");
        return "quiz";
    }

    @PostMapping("/guess")
    public String processGuess(@RequestParam("answer") String userAnswer, Model model) {
        if (currentQuestion == null) {
            return "redirect:/quiz";
        }

        if (userAnswer.equalsIgnoreCase(currentQuestion.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("showRetry", true);
        } else {
            attempts++;
            if (attempts >= 3) {
                model.addAttribute("message", "Bạn hết lượt đoán!");
                model.addAttribute("showRetry", true);
            } else {
                model.addAttribute("message", "Sai rồi! Bạn còn " + (3 - attempts) + " lượt đoán.");
                model.addAttribute("showRetry", false);
            }
        }

        model.addAttribute("question", currentQuestion);
        return "quiz";
    }
}