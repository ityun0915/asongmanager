package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.dto.ProductDTO;
import com.fangzhou.asongmanager.pojo.Product;
import com.fangzhou.asongmanager.pojo.ProductionType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product")
    List<Product> getAllPro();

    @Select("select name from production_type where id=#{id}")
    String getTypeByClassId(int id);

    @Select("select * from product where id like concat('%',#{username},'%') or title like concat('%',#{username},'%') and class_id=#{category} and state=#{state}")
    List<Product> SelProBymohu(String username,Integer category,Integer state);

    @Select("select * from production_type")
    List<ProductionType> SelTypeCate();

    @Select("select * from product where id=#{id}")
    Product SelProductById(Long id);

    @Update("update product set title=#{title}," +
            "class_id=#{type},com_num=#{pinlun},good_num=#{dianzan},down_num=#{xiazai},play_num=#{fenxiang}," +
            "author_id=(select id from author where name=#{author})," +
            "state=#{state} where id=#{id}")
    void UpdateProduct(ProductDTO productDTO);

    @Delete("delete from product where id = #{id}")
    void delProduct(Integer id);

    @Select("select title from product where id=#{id}")
    String getTitleById(String id);

    @Select("select count(1) from product where author_id=#{author_id}")
    int getProCountByAuthorId(Long author_id);

    @Select("select sum(com_num) from product where author_id=#{author_id}")
    int getComCountByAuthorId(Long author_id);

    @Select("select sum(down_num) from product where author_id=#{author_id}")
    int getDownCountByAuthor(Long author_id);

    @Select("select count(1) from product where class_id=#{id} ")
    int getProNumByType(int id);

    @Select("select count(1) from product")
    int getProNum();

    @Select("SELECT COUNT(1) FROM product WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    int getTodayNum();

    @Select("SELECT COUNT(1) FROM product WHERE WEEK(create_time) = WEEK(NOW())")
    int getWeekNum();

    @Select("SELECT COUNT(1) FROM product WHERE MONTH(create_time) = MONTH(NOW())")
    int getMonthNum();

    @Update("update product set state=1 where id=#{id}")
    void Shangjia(String id);

    @Update("update product set state=0 where id=#{id}")
    void xiajia(String id);

    @Update("update product set recommend=true where id=#{id}")
    void tuijian(String id);
}
