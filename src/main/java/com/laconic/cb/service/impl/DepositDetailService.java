package com.laconic.cb.service.impl;

import com.laconic.cb.model.DepositDetail;
import com.laconic.cb.repository.IDepositDetailRepository;
import com.laconic.cb.service.IDepositDetailService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public void deleteDepositDetail(Long id) {
        Optional<DepositDetail> depositDetail = depositDetailRepository.findById(id);
        depositDetailRepository.delete(depositDetail.get());
    }
}
