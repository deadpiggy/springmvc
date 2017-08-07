package cn.hyh.springmvc.service;

import cn.hyh.springmvc.dao.ToyMapper;
import cn.hyh.springmvc.pojo.Toy;
import cn.hyh.springmvc.util.Pager;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository("toyService")
public class ToyService {

    @Resource(name = "toyMapper")
    private ToyMapper toyMapper;

    public List<Toy> find() {
        return toyMapper.find();
    }

    public Toy findById(Integer id) {
        return toyMapper.findById(id);
    }

    public List<Toy> findParam(
            @RequestParam(value = "name")String name,
            @RequestParam(value = "beginDate")Date beginDate,
            @RequestParam(value = "endDate") Date endDate
            ) {
        return toyMapper.findParam(name, beginDate, endDate);
    }

    public Pager<Toy> findPager(Integer page, Integer rows, String sort, String order, String name) {
        Pager<Toy> pager = new Pager<>();
        pager.setTotal(toyMapper.getTotal(name));
        pager.setRows((toyMapper.findPager(page, rows, sort, order, name)));
        return pager;
    }

    public int add(Toy toy) {
        return toyMapper.add(toy);
    }

    public int modify(Toy toy) {
        return toyMapper.modify(toy);
    }

    public int remove(Integer id) {
        return toyMapper.remove(id);
    }
}
