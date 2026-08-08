package org.uam.serviceinventario.mapper.config;

import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Named;
import org.mapstruct.TargetType;
import org.uam.serviceinventario.model.BaseEntity;

import java.util.UUID;

public class EntityIdMapper {

    @Named("entityToId")
    public UUID entityToId(BaseEntity entity) {
        if (entity == null || entity.getUuid() == null) {
            return null;
        }
        return entity.getUuid();
    }

    @Named("idToEntity")
    public <T extends BaseEntity> T idToEntity(UUID id,@TargetType Class<T> clazz)
    {
        if (id == null) {
            return null;
        }
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            entity.setUuid(id);
            return entity;
        }
        catch (Exception e){
            throw new IllegalArgumentException("No se pudo crear la " +
                    "entidad " +  clazz.getSimpleName());
        }
    }
}
