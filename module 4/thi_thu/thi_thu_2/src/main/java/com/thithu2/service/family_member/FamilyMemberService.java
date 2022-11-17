package com.thithu2.service.family_member;

import com.thithu2.model.FamilyMember;
import com.thithu2.repository.IFamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService implements IFamilyMemberService {

    @Autowired
    private IFamilyMemberRepository familyMemberRepository;

    @Override
    public Iterable<FamilyMember> findAll() {
        return familyMemberRepository.findAll();
    }

    @Override
    public Optional<FamilyMember> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public FamilyMember save(FamilyMember familyMember) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<FamilyMember> findAll(Integer houseRegistrationId) {
        return familyMemberRepository.findAll(houseRegistrationId);
    }
}
