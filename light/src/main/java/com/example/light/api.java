package com.example.light;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class api {
    @Autowired
    final RabbitMqSender rabbitMqSender;

    @PostMapping("/{studentId}/{studentName}")
    public @ResponseBody String banUser(@PathVariable("studentId") Integer id, @PathVariable("studentName") String name) {
        User cur = new User(id, name);
        rabbitMqSender.send(cur);
        return cur.toJson();
    }
}
