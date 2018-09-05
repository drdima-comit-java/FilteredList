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

    @Autowired
    private AppsListDaoSqlite appsSql;


    @RequestMapping(value = "/filtered-list-details-view/{flId}", method = RequestMethod.GET)
    public ModelAndView filteredListDetailsView(HttpSession session, @PathVariable int flId) {
        List<FilteredListDetails> listFld = flSql.getFilteredListsDetails(flId);
        flSql.getFilteredListsDetailsWithPath(listFld,appsSql);

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


    @RequestMapping(value = "/d")
    public @ResponseBody
    ResponseEntity<byte[]> down(HttpSession session) {

        String myBatFile = "calc";

        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
        byte[] contents =  myBatFile.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        // Here you have to set the actual filename of your pdf
        String filename = "123.bat";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;

    }


    @RequestMapping(value = "/download/{fldId}")
    public @ResponseBody ResponseEntity<byte[]> down2(HttpSession session , @RequestBody @PathVariable int fldId ) {

        String myBatFile;
        myBatFile=this.generateBatFileString(fldId);


        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
        byte[] contents =  myBatFile.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/bat"));
        // Here you have to set the actual filename of your pdf
        String filename = "runme.bat";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;

    }

    private String generateBatFileString(int fldId)
    {
        if (fldId==-1) return this.generateBathSoftwareList();
        else{
            String fldName = flSql.getFilteredListDetails(fldId).getFldName();
            String appsPath=appsSql.getPathbyName(fldName);
            return '"' + appsPath + '"';
        }
        //return null;


    }

    private String generateBathSoftwareList()
    {
        String myBat;

//        myBat="" +
//                "powershell \"Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName\" >soft.txt\n" +
//                "\n" +
//                "start  notepad soft.txt" +
//                "";
//        myBat="wmic product get name>soft.txt" +
//                "\n" +
//                "start notepad soft.txt";

        myBat="powershell \"Get-ItemProperty HKLM:\\Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName\">soft.txt" +
                "\n" +
                "start notepad soft.txt";
        return  myBat;
    }






}
