package com.example.lightweight_service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class api {
    @Autowired
    final RabbitMqSender rabbitMqSender;

    @PostMapping("/{studentId}/{studentName}")
    public User banUser(@PathVariable("studentId") Integer id, @PathVariable("studentName") String name) {
        User cur = new User(id, name);
        rabbitMqSender.send(cur);
        return cur;
    }
}
