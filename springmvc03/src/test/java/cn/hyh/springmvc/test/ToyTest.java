package cn.hyh.springmvc.test;

import cn.hyh.springmvc.pojo.Toy;
import cn.hyh.springmvc.service.ToyService;
import cn.hyh.springmvc.util.Pager;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ToyTest {

    ToyService toyService;

    @Test
    public void test() {
        System.out.println("Hello World ~!");
    }

    @Test
    public void findById() {
        Toy toy = toyService.findById(10);
        System.out.println(toy.getName());
    }

    @Test
    public void findParam(){
        String name = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        List<Toy> toys = toyService.findParam(name, beginDate, endDate);
        System.out.println(toys.size());
        for (Toy toy : toys){
            System.out.println(toy.getId() + " " + toy.getName());
        }
    }

    @Test
    public void findPager() {
        Integer page = 0;
        Integer rows = 0;
        String sort = "id";
        String order = "asc";

        String name = null;
//        name = "%小%";

        page = (page - 1) * rows;

        Pager<Toy> pager = toyService.findPager(page, rows, sort, order, name);
        System.out.println(pager.getTotal());
        for (Toy toy : pager.getRows()) {
            System.out.println(toy.getId() + " " + toy.getName());
        }

    }

    @Test
    public void find() {
        List<Toy> toys = toyService.find();
        System.out.println(toys.size());
        for (Toy toy : toys) {
            System.out.println(toy.getId() + " " + toy.getName() + " " + toy.getPrice());
        }
    }

    @Test
    public void modify(){
        Toy toy = toyService.findById(19);
        toy.setName("观死");
        int count = toyService.modify(toy);
        if (count > 0){
            System.out.println("修改成功....");
        }else {
            System.out.println("修改失败......");
        }
    }

    @Test
    public void remove(){
        int count = toyService.remove(19);
        if(count > 0){
            System.out.println("删除成功......");
        }else {
            System.out.println("删除失败.......");
        }
    }

    @Test
    public void add() {
        Toy toy = new Toy();
        toy.setName("亨利的永恒追捕");
        toy.setPrice(300d);
        toy.setCreateDate(new Date());
        int count = toyService.add(toy);
        if (count > 0){
            System.out.println("添加成功......");
        }else {
            System.out.println("添加失败......");
        }
    }

    @Test
    public void toy() {
        Toy toy = new Toy();
        toy.setId(1);
        toy.setName("大黄蜂");
        toy.setPrice(80d);
        toy.setCreateDate(new Date());
        System.out.println(toy.toString());
    }

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        toyService = ctx.getBean("toyService", ToyService.class);
    }

}
