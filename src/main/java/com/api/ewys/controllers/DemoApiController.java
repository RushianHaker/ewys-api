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
public class DemoApiController {
    public final DemoService demoService;

    public DemoApiController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo/get_all")
    public List<DemoModel> getDemoInfoList() {
        return demoService.getDemoInfoList();
    }

    @GetMapping("/demo/get/{id}")
    public DemoModel getDemoInfoListById(@NotNull @PathVariable(name = "id") Long id) {
        return demoService.getDemoInfoById(id);
    }

    @GetMapping("/demo/get_names")
    public List<DemoModel> getDemoInfoListByNames(@NotNull @RequestParam(name = "names") List<String> names) {
        List<String> decodedNames = names.stream().map(s -> URLDecoder.decode(s, StandardCharsets.UTF_8)).toList();
        return demoService.getDemoInfoListByNames(decodedNames);
    }

    @PostMapping("/demo/insert")
    public void saveDemoInfoList(@NotNull @RequestBody List<DemoModel> demoList) {
        demoService.saveDemoInfoList(demoList);
    }
}
