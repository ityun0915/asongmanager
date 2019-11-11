package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface ReferralsService {
    Msg getAllReferrals(Integer pn);
    Msg DelReferrals(Long id);
    Msg SelReferralsBymohu(String username,Integer pn);
}
