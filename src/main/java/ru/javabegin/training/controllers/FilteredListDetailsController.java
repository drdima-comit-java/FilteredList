package ru.javabegin.training.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.impls.FilteredListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDetailsStatusesDaoSqlite;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.FilteredListDetails;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatus;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatuses;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class FilteredListDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(NewListController.class);


    @Autowired
    private FilteredListDaoSqlite flSql;

    @Autowired
    private FilteredListDetailsStatusesDaoSqlite fldsSql;


    @RequestMapping(value = "/filtered-list-details-view/{flId}", method = RequestMethod.GET)
    public ModelAndView filteredListDetailsView(HttpSession session, @PathVariable int flId) {
        List<FilteredListDetails> listFld = flSql.getFilteredListsDetails(flId);

        session.setAttribute("flId",flId);
        ModelAndView m = new ModelAndView("filtered-list-details-view","listFld", listFld);

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("filteredListName", flSql.getFilteredList(flId).getFlName());
        m.addAllObjects(map);
        return m;
    }

    @RequestMapping(value = "/filtered-list-details-delete/{fldId}", method = RequestMethod.GET)
    public String filteredListDetailsDelete(HttpSession session, @PathVariable int fldId) {
        //List<FilteredListDetails> listFld = flSql.getFilteredListDetails(flId);
        //ModelAndView m = new ModelAndView("filtered-list-view","listFld", listFld);
        flSql.deleteFldId(fldId);
        return "redirect:/filtered-list-details-view/" + session.getAttribute("flId");
    }



    @RequestMapping(value = "/filtered-list-details-change-status/{fldsId}/{fldId}")
    public @ResponseBody
    FilteredListDetailsStatus filteredListDetailsChangeStatus(HttpSession session, @RequestBody @PathVariable int fldsId , @PathVariable int fldId) {
        //FilteredListDetails fld = flSql.getFilteredListDetails(fldId);

        //int flId = (Integer) session.getAttribute("flId");
        FilteredListDetailsStatuses fldss = ((FilteredListDetailsStatuses)session.getAttribute("fldss"));


        FilteredListDetailsStatus nextFlds = fldss.getNextStatus(fldsId);

        //update db
        flSql.updateFldStatus(fldId,nextFlds.getFldsId());


        //String result="ajax ok";
        //return result;
        return nextFlds;

    }



}
