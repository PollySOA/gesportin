package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.PartidoEntity;

@Getter
@Setter
@NoArgsConstructor
public class PartidoDTO extends PartidoEntity {

    public PartidoDTO(PartidoEntity entity) {
        setId(entity.getId());
        setRival(entity.getRival());
        setLiga(entity.getLiga());
        setLocal(entity.getLocal());
        setResultado(entity.getResultado());
        setFecha(entity.getFecha());
        setLugar(entity.getLugar());
        setComentario(entity.getComentario());
        setEstadopartido(entity.getEstadopartido());
    }
}
