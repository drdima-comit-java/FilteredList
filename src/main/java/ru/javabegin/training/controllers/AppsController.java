package ru.javabegin.training.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.impls.AppsListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDetailsStatusesDaoSqlite;
import ru.javabegin.training.objects.softList.Apps;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatus;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatuses;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppsController {

    private static final Logger logger = LoggerFactory.getLogger(NewListController.class);


    @Autowired
    private AppsListDaoSqlite appsSql;




    @RequestMapping(value = "/app-setup", method = RequestMethod.GET)
    public ModelAndView appsView(HttpSession session) {

        List<Apps> appsList= appsSql.getAppsList();

        ModelAndView m = new ModelAndView("app-setup","appsList",appsList);

//        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("filteredListName", flSql.getFilteredList(flId).getFlName());
//        m.addAllObjects(map);
        return m;
    }


    @RequestMapping(value = "/add-app", method = RequestMethod.POST)
    public String appAdd(HttpSession session, @ModelAttribute Apps apps, HttpServletRequest request ) {

        appsSql.addApp(apps.getAppsName(),apps.getAppsPath());

        String refererURI="";
        //String referrer = request.getHeader("referer");
        try {
            refererURI = new URI(request.getHeader("referer")).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
        }
        //return "redirect:/app-setup";
        return "redirect:" + refererURI;
    }

    @RequestMapping(value = "/delete-app/{appsId}", method = RequestMethod.GET)
    public String appAdd(HttpSession session, @RequestBody @PathVariable int appsId) {

        appsSql.deleteApp(appsId);
        return "redirect:/app-setup";
    }





}
