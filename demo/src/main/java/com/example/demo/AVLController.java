package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*") // Allows your JS file to talk to this Java file
public class AVLController {

    @GetMapping("/api/avl")
    public AVL sendData() {
        // 1. Create your object (or get it from a database)
        AVL tree = new AVL();

        // 2. Return the object directly
        // Spring Boot automatically converts this to: {"name": "Khalid", "age": 21}
        return tree;
    }
}