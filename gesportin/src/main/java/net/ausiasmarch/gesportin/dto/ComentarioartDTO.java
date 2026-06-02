package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.ComentarioartEntity;

@Getter
@Setter
@NoArgsConstructor
public class ComentarioartDTO extends ComentarioartEntity {

    public ComentarioartDTO(ComentarioartEntity entity) {
        setId(entity.getId());
        setContenido(entity.getContenido());
        setArticulo(entity.getArticulo());
        setUsuario(entity.getUsuario());
    }
}
