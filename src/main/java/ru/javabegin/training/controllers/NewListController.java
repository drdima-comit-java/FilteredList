package ru.javabegin.training.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.impls.BaseListDaoSqlite;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.BaseList;
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
}
