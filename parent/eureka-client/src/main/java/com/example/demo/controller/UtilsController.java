package com.example.demo.controller;

import com.example.demo.service.UtilsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@SuppressWarnings(value = "static-access")
@RestController
@RequestMapping(value = "/utils")
public class UtilsController extends BaseController {

    @Resource(name = "utilsService")
    private UtilsService utilsService;

    @RequestMapping(value = "/auto/model", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getModel(HttpServletRequest request,
                           @PathParam(value = "column") String column) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toJSONString(column);
    }

    @RequestMapping(value = "/auto/model", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getSql(HttpServletRequest request,
                         @PathParam(value = "column") String column) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toJSONString(column);
    }

}
