package com.vbaggio.ecom.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.vbaggio.ecom.dto.UserDTO;
import com.vbaggio.ecom.entitites.Role;
import com.vbaggio.ecom.entitites.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO toDto(User user);
	
    default List<String> mapRolesToStrings(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(Role::getAuthority)
                .collect(Collectors.toList());
    }
	
}
