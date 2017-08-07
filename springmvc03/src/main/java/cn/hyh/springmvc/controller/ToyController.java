package cn.hyh.springmvc.controller;

import cn.hyh.springmvc.pojo.Toy;
import cn.hyh.springmvc.service.ToyService;
import cn.hyh.springmvc.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class ToyController {

    @Resource(name = "toyService")
    private ToyService toyService;

    @RequestMapping( "index" )
    public String index() {
        return "index";
    }

    @RequestMapping( "list" )
    public ModelAndView list(
            @RequestParam(value = "name")String name,
            @RequestParam(value = "beginDate")Date beginDate,
            @RequestParam(value = "endDate")Date endDate
            ) {
        List<Toy> toys = toyService.findParam(name, beginDate, endDate);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("list");
        mv.addObject("toys", toys);
        System.out.println("pager.size : " + toys.size());
        return mv;
    }

}
