package com.gulko.controller;


import com.gulko.entity.BasePH;
import com.gulko.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/BaseList")
public class BaseController {

    @Autowired
    private BaseService service;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<BasePH> getAllBase() {
        return service.getAll();
    }

    @RequestMapping(value = "/saveBase", method = RequestMethod.POST)
    @ResponseBody
    public BasePH saveBase(@RequestBody BasePH userBase) {
        return service.save(userBase);
    }

    @RequestMapping(value = "/getBase/{log}",method = RequestMethod.GET)
    @ResponseBody
    public List<BasePH> getAllUserBase(@PathVariable("log") String login){return service.getAllUserBase(login);}

}
