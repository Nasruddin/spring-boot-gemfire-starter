package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nasruddin on 27/11/16.
 */
@RestController
public class DataController {

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/get-data/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public DataModel getData(@PathVariable("id") int id) {

        return dataService.getData(id);
    }

    @RequestMapping(value = "/put-data/{id}/{text}", method = RequestMethod.GET)
    public String putData(@PathVariable("id") int id, @PathVariable("text") String data) {

        dataService.cacheData(id, data);
        return "Cached";
    }

}
