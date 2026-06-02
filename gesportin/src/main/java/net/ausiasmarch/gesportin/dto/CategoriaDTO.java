package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.CategoriaEntity;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO extends CategoriaEntity {

    private int equipos;

    public CategoriaDTO(CategoriaEntity entity, int equipos) {
        setId(entity.getId());
        setNombre(entity.getNombre());
        setTemporada(entity.getTemporada());
        this.equipos = equipos;
    }
}
