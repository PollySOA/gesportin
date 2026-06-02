package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.ComentarioEntity;

@Getter
@Setter
@NoArgsConstructor
public class ComentarioDTO extends ComentarioEntity {

    public ComentarioDTO(ComentarioEntity entity) {
        setId(entity.getId());
        setContenido(entity.getContenido());
        setNoticia(entity.getNoticia());
        setUsuario(entity.getUsuario());
    }
}
