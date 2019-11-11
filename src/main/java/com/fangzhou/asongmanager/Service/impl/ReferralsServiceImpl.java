package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.ReferralsService;
import com.fangzhou.asongmanager.dto.ReferralsDTO;
import com.fangzhou.asongmanager.mapper.ReferralsMapper;
import com.fangzhou.asongmanager.pojo.Referrals;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReferralsServiceImpl implements ReferralsService {
    @Autowired
    private ReferralsMapper referralsMapper;

    @Override
    public Msg getAllReferrals(Integer pn) {
        List<ReferralsDTO> list = new ArrayList<>();
        List<Referrals> result = referralsMapper.getAllReferrals();
        for (Referrals referrals:result){
            ReferralsDTO referralsDTO = new ReferralsDTO();
            referralsDTO.setId(referrals.getId());
            referralsDTO.setName(referrals.getName());
            referralsDTO.setNum(referrals.getNum());
            referralsDTO.setCreate_time(referrals.getCreate_time());

            list.add(referralsDTO);
        }
        Map<String, Object> referralsDTOMaps = PagesMap.getReferralsDTOMaps(list, pn);
        Msg msg =  Msg.success().add("list",referralsDTOMaps);
        return msg;
    }

    @Override
    public Msg DelReferrals(Long id) {
        referralsMapper.DelReferrals(id);
        return Msg.success();
    }

    @Override
    public Msg SelReferralsBymohu(String username, Integer pn) {
        List<ReferralsDTO> list = new ArrayList<>();
        List<Referrals> result = referralsMapper.SelReferralsBymohu(username);
        for (Referrals referrals:result){
            ReferralsDTO referralsDTO = new ReferralsDTO();
            referralsDTO.setId(referrals.getId());
            referralsDTO.setName(referrals.getName());
            referralsDTO.setNum(referrals.getNum());
            referralsDTO.setCreate_time(referrals.getCreate_time());

            list.add(referralsDTO);
        }
        Map<String, Object> referralsDTOMaps = PagesMap.getReferralsDTOMaps(list, pn);
        Msg msg =  Msg.success().add("list",referralsDTOMaps);
        return msg;
    }
}
