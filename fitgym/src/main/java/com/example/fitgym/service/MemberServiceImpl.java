package com.example.fitgym.service;

import com.example.fitgym.entity.MemberEntity;
import com.example.fitgym.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void saveMember(MemberEntity memberEntity) {
        if (memberEntity.getMemberName()==null || memberEntity.getMemberName().isBlank()) {
            throw new IllegalArgumentException("Name is requried");
        }
        if (memberEntity.getTotalAmount() < 0 || memberEntity.getPaidAmount() < 0) {
            throw new IllegalArgumentException("Amount is requried");
        }

        double balance = memberEntity.getTotalAmount() - memberEntity.getPaidAmount();
        memberEntity.setPaidAmount(balance);

        memberRepository.save(memberEntity);
    }

    @Override
    public List<MemberEntity> getAllMember() {
        return memberRepository.findAll();
    }
}
