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

import ru.javabegin.training.interfaces.BaseListDao;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.BaseList;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseListController {


    private static final Logger logger = LoggerFactory.getLogger(BaseListController.class);

    @Autowired
    private BaseListDaoSqlite sqlite;

    @RequestMapping(value = "/base-lists", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session) {
        List<BaseList> blList= sqlite.getBaseLists( ((User) session.getAttribute("user")  ).getIduser()  );
        return new ModelAndView("base-lists","blList",blList);
    }


    @RequestMapping(value = "/base-lists-insert", method = RequestMethod.POST)
    public String saveBaseList(HttpSession session, @ModelAttribute BaseList bl) {

        User user=(User) session.getAttribute("user");
        //System.out.println(u.getIduser());
        //System.out.println(bl.getListName());
        bl.setUser(user);


        this.sqlite.insert(bl);


        return "redirect:/base-lists";
        //return new ModelAndView("base-lists");
    }


    @RequestMapping(value = "/base-list-delete/{idbl}", method = RequestMethod.GET)
    public String deleteBaseList(HttpSession session, @ModelAttribute BaseList bl, @PathVariable int idbl) {


        this.sqlite.delete(idbl);
        return "redirect:/base-lists";
    }


    @RequestMapping(value = "/base-list-edit/{idbl}", method = RequestMethod.GET)
    public ModelAndView editBaseList(HttpSession session, @PathVariable int idbl) {


        BaseList bl=this.sqlite.getBaseList(idbl);
        //ModelAndView m = new ModelAndView("base-list-create","baseList", bl) ;
        ModelAndView m = new ModelAndView("new-list-create","newList", bl) ;

        Map<String, Object> map = new HashMap<String,Object>();

        map.put("submitText", "Update Base List");
        map.put("listMode", "baseList");
        map.put("formAction", "/base-list-update/"+idbl);
        //map.put("submitMsg", "Update Base List");
        //map.put("pageName", "UPDATE Base List");
        //map.put("pageAction", "/base-list-update/"+idbl);
        m.addAllObjects(map);
        return m;
    }


    @RequestMapping(value = "/base-list-update/{idbl}", method = RequestMethod.POST)
    public String updateBaseList(HttpSession session, @ModelAttribute BaseList bl, @PathVariable int idbl) {

        //bl.setUser( (User)session.getAttribute("user") );
        bl.setIdbl(idbl);
        this.sqlite.update(bl);

        return "redirect:/base-lists";
    }



    @RequestMapping(value = "/base-list-create", method = RequestMethod.GET)
    public ModelAndView baseListCreate(HttpSession session) {
        BaseList bl = new BaseList();
        bl.setListDate(new Date());

        //ModelAndView m =new ModelAndView("base-list-create","baseList", bl);
        ModelAndView m =new ModelAndView("new-list-create","newList", bl);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("submitText", "Update Base List");
        map.put("listMode", "baseList");
        map.put("formAction", "/base-lists-insert");


//        map.put("submitMsg", "Save my Base List");
//        map.put("pageName", "New Base List");
//        map.put("pageAction", "/base-lists-insert");
        m.addAllObjects(map);
        return m;
    }


}
