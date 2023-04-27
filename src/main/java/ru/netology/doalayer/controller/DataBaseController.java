package ru.netology.doalayer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.doalayer.service.DataBaseService;

import java.util.List;

@RestController
public class DataBaseController {

    private final DataBaseService dataBaseService;

    DataBaseController(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public ResponseEntity<List<String>> getProductName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(dataBaseService.getProductName(name));
    }
}
