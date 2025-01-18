package org.practice.tacoproject.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.practice.tacoproject.repository.TacoOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.practice.tacoproject.entity.TacoOrder;
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @Autowired
    TacoOrderRepository tacoOrderRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder order,
                               SessionStatus sessionStatus) {
        tacoOrderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}