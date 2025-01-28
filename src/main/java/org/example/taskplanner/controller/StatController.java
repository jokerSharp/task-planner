package org.example.taskplanner.controller;

import lombok.AllArgsConstructor;
import org.example.taskplanner.entity.Stat;
import org.example.taskplanner.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class StatController {

    private final StatService statService;

    @PostMapping("api/stats")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(statService.findStat(email));
    }
}
