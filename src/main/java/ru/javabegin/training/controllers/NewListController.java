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
import ru.javabegin.training.interfaces.FilteredListDao;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.BaseList;
import ru.javabegin.training.objects.softList.FilteredList;
import ru.javabegin.training.objects.softList.NewList;

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

    @Autowired
    private BaseListDaoSqlite blSql;

    @Autowired
    private FilteredListDaoSqlite flSql;

    @RequestMapping(value = "/new-list-create", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session) {


        Map<String,String> blListsMap = blSql.getBaseListsMap( ((User)session.getAttribute("user")).getIduser()  );
        ModelAndView m = new ModelAndView("new-list-create","newList", new NewList());
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("blLists", blListsMap);
        m.addAllObjects(map);

        return m;
    }

    @ModelAttribute("baseLists")
    public Map<String, String> getBaseLists(HttpSession session) {
        Map<String, String> baseLists = blSql.getBaseListsMap(  ((User)session.getAttribute("user")).getIduser() );
        return baseLists;
    }


    @RequestMapping(value = "/new-list-add", method = RequestMethod.POST)
    public ModelAndView newListAdd(HttpSession session, @ModelAttribute NewList newList) {
    //public ModelAndView newListAdd(HttpSession session, @ModelAttribute NewList newList) {
    //public ModelAndView newListAdd(HttpSession session) {


        User user=( ((User)session.getAttribute("user"))  );
        BaseList baseList = blSql.getBaseList(newList.getBaseListId());

        FilteredList filteredList = new FilteredList(baseList,newList);
        filteredList.removeBaseListItems();

        flSql.insertFilteredList(filteredList);

        System.out.println("new list add");

        ModelAndView m  = new ModelAndView();
        return m;
    }



}
