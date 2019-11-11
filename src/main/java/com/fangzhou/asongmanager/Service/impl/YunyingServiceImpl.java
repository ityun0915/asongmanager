package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.YunyingService;
import com.fangzhou.asongmanager.dto.ProductionTypeDTO;
import com.fangzhou.asongmanager.mapper.ProductMapper;
import com.fangzhou.asongmanager.mapper.YunyingMapper;
import com.fangzhou.asongmanager.pojo.ProductionType;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class YunyingServiceImpl implements YunyingService {

    @Autowired
    private YunyingMapper yunyingMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Msg getAllProType(Integer pn) {
        List<ProductionTypeDTO> list = new ArrayList<>();
        List<ProductionType> result = yunyingMapper.getAllProType();
        for (ProductionType productionType:result){
            ProductionTypeDTO productionTypeDTO = new ProductionTypeDTO();
            productionTypeDTO.setId(productionType.getId());
            productionTypeDTO.setName(productionType.getName());

            //查询作品表中,同一作品类型的作品数
            int pro_num = productMapper.getProNumByType(productionType.getId());
            System.out.println("pro_num:"+pro_num);
            productionTypeDTO.setPro_num(pro_num);
            list.add(productionTypeDTO);
        }

        Map<String, Object> proTypeDTOMaps = PagesMap.getProTypeDTOMaps(list, pn);
        Msg msg = Msg.success().add("list",proTypeDTOMaps);
        return msg;
    }

    @Override
    public Msg SelProTypeBymohu(String username, Integer pn) {
        List<ProductionTypeDTO> list = new ArrayList<>();
        List<ProductionType> result = yunyingMapper.SelProTypeBymohu(username);
        for (ProductionType productionType:result){
            ProductionTypeDTO productionTypeDTO = new ProductionTypeDTO();
            productionTypeDTO.setId(productionType.getId());
            productionTypeDTO.setName(productionType.getName());

            //查询作品表中,同一作品类型的作品数
            int pro_num = productMapper.getProNumByType(productionType.getId());
            System.out.println("pro_num:"+pro_num);
            productionTypeDTO.setPro_num(pro_num);
            list.add(productionTypeDTO);
        }

        Map<String, Object> proTypeDTOMaps = PagesMap.getProTypeDTOMaps(list, pn);
        Msg msg = Msg.success().add("list",proTypeDTOMaps);
        return msg;
    }

    @Override
    public Msg DelProType(Integer id) {
        yunyingMapper.DelProType(id);
        return Msg.success();
    }

    @Override
    public Msg UpdateProType(Integer id, String protype) {
        yunyingMapper.UpdateProType(id,protype);
        return Msg.success();
    }

    @Override
    public Msg selProTypeNameById(Integer id) {
        ProductionType productionType = yunyingMapper.selProTypeNameById(id);
        Msg msg = Msg.success().add("user",productionType);
        return msg;
    }

    @Override
    public Msg addProType(String protype) {
        //先判断是否存在该作品类型
        ProductionType productionType = yunyingMapper.selProTypeByName(protype);
        if (productionType != null){
            return Msg.fail().add("list","占用");
        }
        //将要传入的数据封装到ProductionType对象
//        ProductionType productionType1 = new ProductionType();
        //获取创建和修改时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());



        yunyingMapper.addProType(protype,timestamp);

        return null;
    }
}
