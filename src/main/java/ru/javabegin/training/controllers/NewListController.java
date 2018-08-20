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
import org.springframework.web.servlet.ModelAndViewDefiningException;
import ru.javabegin.training.impls.BaseListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDaoSqlite;
import ru.javabegin.training.impls.FilteredListDetailsStatusesDaoSqlite;
import ru.javabegin.training.interfaces.FilteredListDao;
import ru.javabegin.training.interfaces.FilteredListDetailsStatusesDao;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.BaseList;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.NewList;
import ru.javabegin.training.objects.softList.Util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/*
convert object to xml
StringWriter sw = new StringWriter();
jaxbMarshaller.marshal(customer, sw);
String xmlString = sw.toString();
 */


@Controller
public class NewListController {

    private static final Logger logger = LoggerFactory.getLogger(NewListController.class);

    //private FilteredList filteredList;

    @Autowired
    private BaseListDaoSqlite blSql;

    @Autowired
    private FilteredListDaoSqlite flSql;

    @Autowired
    private FilteredListDetailsStatusesDaoSqlite fldsSql;

    @RequestMapping(value = "/new-list-create", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session) {
        //Util.sessionCheck(session);
        Map<String, String> blListsMap;
        try {
            blListsMap = blSql.getBaseListsMap(((User) session.getAttribute("user")).getIduser());
        }
        catch (Exception e)
        {
            return new ModelAndView("login","user", new User());

        }
        NewList nl = new NewList();
        User user=( ((User)session.getAttribute("user"))  );

        nl.setUser(user);
        ModelAndView m = new ModelAndView("new-list-create","newList", nl);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("submitText", "Filter List");
        map.put("blLists", blListsMap);
        map.put("formAction", "/new-list-add");
        m.addAllObjects(map);

        return m;
    }

    @ModelAttribute("baseLists")
    public Map<String, String> getBaseLists(HttpSession session) {
        Map<String, String> baseLists = blSql.getBaseListsMap(  ((User)session.getAttribute("user")).getIduser() );
        return baseLists;
    }


    @RequestMapping(value = "/new-list-add", method = RequestMethod.POST)
    public String newListAdd(HttpSession session, @ModelAttribute NewList newList) {
    //public ModelAndView newListAdd(HttpSession session, @ModelAttribute NewList newList) {
    //public ModelAndView newListAdd(HttpSession session) {


        User user=( ((User)session.getAttribute("user"))  );
        newList.setUser(user);
        BaseList baseList = blSql.getBaseList(newList.getIdbl());


        //find minimal fldsId by fldsSort
        int fldsIdInitial = fldsSql.getInitialFldsId();

        FilteredList filteredList = new FilteredList(baseList,newList);
        filteredList.removeBaseListItems(fldsIdInitial);

        flSql.insertFilteredList(filteredList);

        //this.filteredList = filteredList;

        //System.out.println("new list add");
        return "redirect:/filtered-list-details-view/" + filteredList.getFlId();


    }






}
