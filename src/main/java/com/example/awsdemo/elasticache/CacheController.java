package com.example.awsdemo.elasticache;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        cacheService.saveData(key, value);
        return "Saved key=" + key;
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        return "Value: " + cacheService.getData(key);
    }
}
