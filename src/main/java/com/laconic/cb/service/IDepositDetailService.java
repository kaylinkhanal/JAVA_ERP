package com.laconic.cb.service;

import com.laconic.cb.model.DepositDetail;

public interface IDepositDetailService {
    DepositDetail saveDepositDetail(DepositDetail depositDetail);
    DepositDetail updateDepositDetail(DepositDetail depositDetail);

    void deleteDepositDetail(Long id);
}
