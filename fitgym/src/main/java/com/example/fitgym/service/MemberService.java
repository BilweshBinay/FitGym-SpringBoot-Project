package com.example.fitgym.service;

import com.example.fitgym.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    void saveMember(MemberEntity memberEntity);
    List<MemberEntity> getAllMember();
}