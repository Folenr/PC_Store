package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*") // Allows your JS file to talk to this Java file
public class AVLController {

    @GetMapping("/api/avl")
    public List<Node> sendData() {
        List<Node> nodes = new ArrayList<>();
        AVL tree = new AVL();
        tree.root = tree.insertNode(tree.root, 10, 15, 0, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 0);
        tree.root = tree.insertNode(tree.root, 20, 29, 25, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 22);
        tree.root = tree.insertNode(tree.root, 30, 17, 0, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 13);
        tree.root = tree.insertNode(tree.root, 40, 12, 0, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 0);
        tree.root = tree.insertNode(tree.root, 50, 22, 0, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 25);
        tree.root = tree.insertNode(tree.root, 25, 65, 43, 20, "Rubiks-Cube", "Rubiks-Cube.jpg", "others", 50);
        tree.traversal(tree.root, nodes);
        // 2. Return the object directly
        // Spring Boot automatically converts this to: {"name": "Khalid", "age": 21}
        return nodes;
    }
}