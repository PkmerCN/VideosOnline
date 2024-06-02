package org.hzz.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/2
 */
@Slf4j
@Controller
@RequestMapping({"/", "index", "index.html", "index.htm"})
public class IndexController {


    private Integer serverPort;
    private Map<String,Object> modelMap;

    public IndexController(@Value("${server.port}") Integer port){
        serverPort = port;
        modelMap = new HashMap<>();
    }

    @PostConstruct
    public void init(){
        ClassPathResource classPathResource = new ClassPathResource("info.txt");
        try {
            String contents = Files.readString(Paths.get(classPathResource.getURI()));
            modelMap.put("contents",contents);
            modelMap.put("server",String.format("🛜Server Run On %d",serverPort));
            modelMap.put("api",String.format("📖Generate Online API: http://localhost:%d/doc/index.html",serverPort));
            modelMap.put("link",String.format("http://localhost:%d/doc/index.html",serverPort));
        } catch (IOException e) {
            log.info("read info.txt error.");
        }
    }

    @RequestMapping(produces = {"text/html"})
    public ModelAndView indexHtml(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addAllObjects(modelMap);
        return modelAndView;
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> indexJson() {
        Map<String, Object> body = Map.of(
                "message", "Welcome To My Project",
                "desc", "This is a json API"
        );
        return new ResponseEntity<>(modelMap, HttpStatus.OK);
    }

}
