package com.api.ewys.controllers;

import com.api.ewys.models.DemoModel;
import com.api.ewys.service.DemoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoApi {
    public final DemoService demoService;

    public DemoApi(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo/get")
    public List<DemoModel> getDemoInfoList(@NotNull @RequestParam(name = "names") List<String> names) {
        List<String> decodedNames = names.stream().map(s -> URLDecoder.decode(s, StandardCharsets.UTF_8)).toList();
        return demoService.allDemoInfoListByNames(decodedNames);
    }

    @PostMapping("/demo/insert")
    public void saveDemoInfoList(@NotNull @RequestBody List<DemoModel> demoList) {
        demoService.saveDemoInfoList(demoList);
    }
}
