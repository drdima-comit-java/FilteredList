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
import ru.javabegin.training.impls.FilteredListDaoSqlite;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.NewList;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class FilteredListDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(NewListController.class);


    @Autowired
    private FilteredListDaoSqlite flSql;


    @RequestMapping(value = "/filtered-list-details-view/{flId}", method = RequestMethod.GET)
    public ModelAndView filteredListDetailsView(HttpSession session, @PathVariable int flId) {
        List<FilteredListDetails> listFld = flSql.getFilteredListDetails(flId);

        session.setAttribute("flId",flId);
        ModelAndView m = new ModelAndView("filtered-list-details-view","listFld", listFld);
        return m;
    }

    @RequestMapping(value = "/filtered-list-details-delete/{fldId}", method = RequestMethod.GET)
    public String filteredListDetailsDelete(HttpSession session, @PathVariable int fldId) {
        //List<FilteredListDetails> listFld = flSql.getFilteredListDetails(flId);
        //ModelAndView m = new ModelAndView("filtered-list-view","listFld", listFld);
        flSql.deleteFldId(fldId);
        return "redirect:/filtered-list-details-view/" + session.getAttribute("flId");
    }

}
