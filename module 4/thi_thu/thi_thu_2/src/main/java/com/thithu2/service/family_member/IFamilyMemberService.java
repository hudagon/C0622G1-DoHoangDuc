package com.thithu2.service.family_member;

import com.thithu2.model.FamilyMember;
import com.thithu2.service.IGeneralService;

import java.util.List;

public interface IFamilyMemberService extends IGeneralService<FamilyMember> {

    List<FamilyMember> findAll(Integer houseRegistrationId);

}
