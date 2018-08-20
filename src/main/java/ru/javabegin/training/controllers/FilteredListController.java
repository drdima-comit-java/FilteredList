package ru.javabegin.training.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.impls.BaseListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDaoSqlite;
import ru.javabegin.training.interfaces.FilteredListDao;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.BaseList;
import ru.javabegin.training.objects.softList.FilteredList;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FilteredListController {


    private static final Logger logger = LoggerFactory.getLogger(NewListController.class);


    @Autowired
    private FilteredListDaoSqlite flSql;

    @RequestMapping(value = "/filtered-lists-view", method = RequestMethod.GET)
    public ModelAndView flViewList(HttpSession session) {
        List<FilteredList> flList= flSql.getFilteredLists ( ((User) session.getAttribute("user")  ).getIduser()  );
        return new ModelAndView("filtered-lists-view","flList",flList);
    }



    @RequestMapping(value = "/filtered-list-delete/{flId}", method = RequestMethod.GET)
    public String flDelete(HttpSession session, @PathVariable int flId) {


        flSql.flDelete(flId);
        return "redirect:/filtered-lists-view";
    }

}
