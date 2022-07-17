package com.laconic.cb.service.impl;

import com.laconic.cb.model.DepositDetail;
import com.laconic.cb.repository.IDepositDetailRepository;
import com.laconic.cb.service.IDepositDetailService;
import org.springframework.stereotype.Service;

@Service
public class DepositDetailService implements IDepositDetailService {
    private final IDepositDetailRepository depositDetailRepository;

    public DepositDetailService(IDepositDetailRepository depositDetailRepository) {
        this.depositDetailRepository = depositDetailRepository;
    }

    @Override
    public DepositDetail saveDepositDetail(DepositDetail depositDetail) {
        return depositDetailRepository.save(depositDetail);
    }

    @Override
    public DepositDetail updateDepositDetail(DepositDetail depositDetail) {
        return depositDetailRepository.saveAndFlush(depositDetail);
    }
}
