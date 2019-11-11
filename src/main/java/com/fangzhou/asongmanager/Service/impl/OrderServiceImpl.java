package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.OrderService;
import com.fangzhou.asongmanager.dto.OrderDTO;
import com.fangzhou.asongmanager.mapper.AuthorMapper;
import com.fangzhou.asongmanager.mapper.OrderMapper;
import com.fangzhou.asongmanager.mapper.ProductMapper;
import com.fangzhou.asongmanager.mapper.UserMapper;
import com.fangzhou.asongmanager.pojo.Asong_order;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper ProductMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Msg getAllOrder(Integer pn) {
        List<OrderDTO> list = new ArrayList<>();

        List<Asong_order> result = orderMapper.getAllOrder();
        for (Asong_order order:result){
            OrderDTO orderDTO = new OrderDTO();
            System.out.println("order:"+order);
            orderDTO.setOrder_num(order.getOrder_num());
            orderDTO.setMoney(order.getMoney());
            orderDTO.setCreate_time(order.getCreate_time());
            orderDTO.setState(order.getState());

            //作品id获取作品名
            String product_name = " ";
            String product_id = order.getProduct_id();
            String[] ids = product_id.split("-");
            for (int i=0;i<ids.length;i++){
                    String titleById = ProductMapper.getTitleById(ids[i]);
                    if (titleById != null){
                        product_name = titleById +"<br>"+product_name;
                    }

            }
            orderDTO.setProduct_name(product_name);
            //用户id获取用户名
            String buyer = userMapper.getUsernameById(order.getUser_id());
            orderDTO.setBuyer(buyer);

            orderDTO.setPaytype("微信支付");
            orderDTO.setState(order.getState());

            list.add(orderDTO);

        }
        Map<String, Object> orderMaps = PagesMap.getOrderMaps(list, pn);
        Msg msg = Msg.success().add("list",orderMaps);
        return msg;
    }

    @Override
    public Msg SelOrderBymohu(String username, String timescope, Integer state,Integer pn) {
        List<OrderDTO> list = new ArrayList<>();
        if ("week".equalsIgnoreCase(timescope)){
            List<Asong_order> result = orderMapper.SelOrderBymohu2(username,timescope,state);
            for (Asong_order order:result){
                OrderDTO orderDTO = new OrderDTO();
                System.out.println("order:"+order);
                orderDTO.setOrder_num(order.getOrder_num());
                orderDTO.setMoney(order.getMoney());
                orderDTO.setCreate_time(order.getCreate_time());
                orderDTO.setState(order.getState());

                //作品id获取作品名
                String product_name = " ";
                String product_id = order.getProduct_id();
                String[] ids = product_id.split("-");
                for (int i=0;i<ids.length;i++){
                    String titleById = ProductMapper.getTitleById(ids[i]);
                    if (titleById != null){
                        product_name = titleById +"<br>"+product_name;
                    }

                }
                orderDTO.setProduct_name(product_name);

                //用户id获取用户名
                String buyer = userMapper.getUsernameById(order.getUser_id());
                orderDTO.setBuyer(buyer);

                orderDTO.setPaytype("微信支付");
                orderDTO.setState(order.getState());

                list.add(orderDTO);

            }
        }
        if ("month".equalsIgnoreCase(timescope)) {
            List<Asong_order> result = orderMapper.SelOrderBymohu(username, timescope, state);
            for (Asong_order order:result){
                OrderDTO orderDTO = new OrderDTO();
                System.out.println("order:"+order);
                orderDTO.setOrder_num(order.getOrder_num());
                orderDTO.setMoney(order.getMoney());
                orderDTO.setCreate_time(order.getCreate_time());
                orderDTO.setState(order.getState());

                //作品id获取作品名
                String product_name = " ";
                String product_id = order.getProduct_id();
                String[] ids = product_id.split("-");
                for (int i=0;i<ids.length;i++){
                    String titleById = ProductMapper.getTitleById(ids[i]);
                    if (titleById != null){
                        product_name = titleById +"<br>"+product_name;
                    }

                }
                orderDTO.setProduct_name(product_name);
                //用户id获取用户名
                String buyer = userMapper.getUsernameById(order.getUser_id());
                orderDTO.setBuyer(buyer);

                orderDTO.setPaytype("微信支付");
                orderDTO.setState(order.getState());

                list.add(orderDTO);

            }

        }
        Map<String, Object> orderMaps = PagesMap.getOrderMaps(list, pn);
        Msg msg = Msg.success().add("list",orderMaps);
        return msg;
    }
}
