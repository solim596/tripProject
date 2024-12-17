package com.example.trip.controller;

import com.example.trip.dto.Item;
import com.example.trip.service.ItemApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class ApiController {
    private final ItemApiService itemApiService;
    @GetMapping("/api")
    public List<Item> getItems(@RequestParam("query") String query) {
        query = URLDecoder.decode(query, StandardCharsets.UTF_8);
        return itemApiService.searchItem(query);
    }
}
