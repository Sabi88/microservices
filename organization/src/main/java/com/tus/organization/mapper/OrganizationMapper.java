package com.tus.organization.mapper;

import com.tus.organization.dto.OrganizationDto;
import com.tus.organization.entity.Organization;

public class OrganizationMapper {
	public static OrganizationDto mapToAccountsDto(Organization organization, OrganizationDto organizationDto) {
		organizationDto.setName(organization.getName());
		organizationDto.setAddress(organization.getAddress());
        return organizationDto;
    }

    public static Organization mapToAccounts(OrganizationDto organizationDto, Organization organization) {
    	organization.setName(organizationDto.getName());
    	organization.setAddress(organizationDto.getAddress());
        return organization;
    }
}
