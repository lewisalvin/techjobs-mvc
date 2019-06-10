package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.DocFlavor;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {
    static HashMap<String, String> columnChoices = new HashMap<>();


    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results



    @RequestMapping(value = "results")
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        //model.addAttribute("valueProcess", JobData.findByValue(searchTerm));
        //model.addAttribute("columnValue", JobData.findByColumnAndValue(searchType, searchTerm));

        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();

        if (searchType.equals("all")){
            //ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            jobs = JobData.findByValue(searchTerm);
            model.addAttribute("jobs", jobs);
        } else {
            //ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("jobs", jobs);

        }



        //System.out.println("****!!!!" + jobs + "!!!*******");

        return "search";


    }

}
