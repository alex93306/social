//package org.mycompany.transformers;
//
//import org.mycompany.beans.Profile;
////import org.mycompany.dto.ProfileRequestDTO;
//import org.mycompany.dto.ProfileResponseDTO;
//import org.mycompany.dto.ProfileUpdateDTO;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProfileTransformer {
////    public void populateEntity(ProfileRequestDTO dto, Profile profile) {
////        profile.setFirstName(dto.getFirstName());
////        profile.setLastName(dto.getLastName());
////        profile.setBirthDate(dto.getBirthDate());
////        profile.setGender(dto.getGender());
////        profile.setRelationshipStatus(dto.getRelationshipStatus());
////
////    }
//
//    public ProfileResponseDTO populateDTO(Profile profile) {
//
//        ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO();
//        profileResponseDTO.setProfileID(profile.getId());
//        profileResponseDTO.setBirthDate(profile.getBirthDate());
//        profileResponseDTO.setGender(profile.getGender());
//        profileResponseDTO.setRelationshipStatus(profile.getRelationshipStatus());
//        profileResponseDTO.setFirstName(profile.getFirstName());
//        profileResponseDTO.setLastName(profile.getLastName());
//
//        return profileResponseDTO;
//    }
//
//    public Profile populateEntity(ProfileUpdateDTO profileUpdateDTO) {
//        Profile profile = new Profile();
//        BeanUtils.copyProperties(profileUpdateDTO, profile);
//        return profile;
//    }
//}
