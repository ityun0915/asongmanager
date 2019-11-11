package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.ReferralsService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/referrals")
public class ReferralsController {

    @Autowired
    private ReferralsService referralsService;

    @RequestMapping("/getAllReferrals")
    public Msg getAllReferrals(@RequestParam("pn")Integer pn){
        Msg msg = referralsService.getAllReferrals(pn);
        return msg;
    }

    @PostMapping("/DelReferrals")
    public Msg DelReferrals(@RequestParam("id")Long id){
        Msg msg = referralsService.DelReferrals(id);
        return msg;
    }

    @PostMapping("/SelReferralsBymohu")
    public Msg SelReferralsBymohu(@RequestParam("username")String username,
                                  @RequestParam("pn")Integer pn){
        Msg msg = referralsService.SelReferralsBymohu(username,pn);
        return msg;
    }
}
