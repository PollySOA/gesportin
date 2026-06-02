package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.TipoarticuloEntity;

@Getter
@Setter
@NoArgsConstructor
public class TipoarticuloDTO extends TipoarticuloEntity {

    private int articulos;
    private Double totalVentas;

    public TipoarticuloDTO(TipoarticuloEntity entity, int articulos, Double totalVentas) {
        setId(entity.getId());
        setDescripcion(entity.getDescripcion());
        setClub(entity.getClub());
        this.articulos = articulos;
        this.totalVentas = totalVentas;
    }
}

