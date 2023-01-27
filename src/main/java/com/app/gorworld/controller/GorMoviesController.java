package com.app.gorworld.controller;

import com.app.gorworld.model.GorMovies;
import com.app.gorworld.service.GorMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gor")
public class GorMoviesController {
    @Autowired
    GorMoviesService gorMoviesService;

    @GetMapping("/list")
    public List<GorMovies> listMovies(){
        GorMovies m1 = new GorMovies(new UUID(0,1),"Movie1","Movie1Image","Movie1Video");
        GorMovies m2 = new GorMovies(new UUID(0,2),"Movie2","Movie2Image","Movie2Video");
        GorMovies m3 = new GorMovies(new UUID(0,3),"Movie3","Movie3Image","Movie3Video");
        GorMovies m4 = new GorMovies(new UUID(0,4),"Movie4","Movie4Image","Movie4Video");
        GorMovies m5 = new GorMovies(new UUID(0,5),"Movie5","Movie5Image","Movie5Video");
        GorMovies m6 = new GorMovies(new UUID(0,6),"Movie6","Movie6Image","Movie6Video");
        GorMovies m7 = new GorMovies(new UUID(0,7),"Movie7","Movie7Image","Movie7Video");
        GorMovies m8 = new GorMovies(new UUID(0,8),"Movie8","Movie8Image","Movie8Video");
        gorMoviesService.saveMovies(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8));
        return gorMoviesService.listMovies();
    }

    @GetMapping("test")
    public String test(){
        return "test successfull";
    }
}
