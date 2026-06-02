package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.LigaEntity;

@Getter
@Setter
@NoArgsConstructor
public class LigaDTO extends LigaEntity {

    private int partidos;

    public LigaDTO(LigaEntity entity, int partidos) {
        setId(entity.getId());
        setNombre(entity.getNombre());
        setEquipo(entity.getEquipo());
        this.partidos = partidos;
    }
}
