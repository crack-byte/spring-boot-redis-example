package com.crackbyte;

import com.crackbyte.domain.User;
import com.crackbyte.service.TempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/user")
public class HelloController {
    @Autowired
    private TempService tempService;

    @GetMapping
    public ResponseEntity<Object> fetch(@RequestParam String id) {
        return new ResponseEntity<>(tempService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User user) {
        log.info("{}");
        tempService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
