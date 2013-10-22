
package com.willoem.springblog.controllers;

import com.willoem.springblog.services.GitHubService;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CodeController {
    
    @Autowired
    private GitHubService ghService;
    
    @RequestMapping(value="/code", method=RequestMethod.GET)
    public String codePage(ModelMap map)
            throws MalformedURLException, Exception
    {
        List<Map<String,String>> repos = ghService.getReposByUser("willOEM"); //change to project parameter
        map.addAttribute("repos", repos);
        return "code";
    }
    
}
