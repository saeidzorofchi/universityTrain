package com.zorofchi.universitytrain.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("index")
public class IndexContoller {
    public Date getDate(){
        return new Date();
    }


}
