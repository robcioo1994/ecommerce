package com.robert.ecommerce.utils.converter;

import com.robert.ecommerce.dto.DescriptionDTO;
import com.robert.ecommerce.entity.DescriptionEntity;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class AdditionalDescriptionConverter extends CustomConverter<DescriptionEntity, DescriptionDTO> {

    @Override
    public DescriptionDTO convert(DescriptionEntity descriptionEntity, Type<? extends DescriptionDTO> type) {

        DescriptionDTO descriptionDTO = new DescriptionDTO();
        descriptionDTO.setId(descriptionEntity.getId());
        descriptionDTO.setImage(Base64.getEncoder().encodeToString(descriptionEntity.getImage()));
        descriptionDTO.setTitle(descriptionEntity.getTitle());
        descriptionDTO.setDescription(descriptionEntity.getDescription());

        return descriptionDTO;
    }
}
