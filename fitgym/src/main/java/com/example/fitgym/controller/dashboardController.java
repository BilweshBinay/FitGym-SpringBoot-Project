package com.example.fitgym.controller;

import com.example.fitgym.entity.MemberEntity;
import com.example.fitgym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class dashboardController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String membersPage(Model model) {
        model.addAttribute("memberEntity", new MemberEntity());
        return "admin/members";
    }

    @PostMapping("/save-member")
    public String saveMember(@ModelAttribute MemberEntity memberEntity){
        memberService.saveMember(memberEntity);
        return "redirect:/admin/members";
    }

    @GetMapping("/memberDetail")
    public String memberDetail(Model model) {
        model.addAttribute("memberList",memberService.getAllMember());
        return "admin/membersdetails";
    }
}
