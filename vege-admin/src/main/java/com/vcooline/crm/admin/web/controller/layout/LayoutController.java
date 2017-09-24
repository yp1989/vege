package com.vcooline.crm.admin.web.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xinbaojian on 15/7/20.
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {

    @RequestMapping("/stylesheets")
    public String stylesheets() {
        return "layout/stylesheets";
    }
    @RequestMapping("/scripts")
    public String scripts() {
        return "layout/scripts";
    }
    @RequestMapping("/navbar")
    public String navbar() {
        return "layout/navbar";
    }
    @RequestMapping("/sidebar")
    public String sidebar() {
        return "layout/sidebar";
    }
    @RequestMapping("/breadcrumbs")
    public String breadcrumbs() {
        return "layout/breadcrumbs";
    }
    @RequestMapping("/footer")
    public String footer() {
        return "layout/footer";
    }

}
