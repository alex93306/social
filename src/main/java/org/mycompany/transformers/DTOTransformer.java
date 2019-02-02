package org.mycompany.transformers;

import org.mycompany.beans.AbstractBean;
import org.mycompany.dto.AbstractDTO;

public interface DTOTransformer<T extends AbstractBean, R extends AbstractDTO, K extends AbstractResponseDTO> {
    T populateEntity(R dto);
    K populateDTO(T entity);
}
