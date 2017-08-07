package cn.hyh.springmvc.dao;

import cn.hyh.springmvc.pojo.Toy;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("toyMapper")
public interface ToyMapper {

    @Select("select id, name, price, create_date createDate from toy")
    public List<Toy> find();

    List<Toy> findParam(
            @Param("name") String name,
            @Param("beginDate") Date beginDate,
            @Param("endDate") Date endDate
    );

    List<Toy> findPager(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort") String sort,
            @Param("order") String order,
            @Param("name") String name
    );

    int getTotal(
            @Param("name") String name
    );

    @Select("select * from toy where id=#{id}")
    Toy findById( Integer id );

    @Delete("delete from toy where id=#{id}")
    int remove(Integer id);

    @Insert("insert into toy(name, price, create_date) values(#{name}, #{price}, #{createDate})")
    int add(Toy toy);

    @Update("update toy set name=#{name}, price=#{price}, create_date=#{createDate} where id=#{id}")
    int modify( Toy toy );
}
