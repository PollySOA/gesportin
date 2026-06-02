package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.CompraEntity;

@Getter
@Setter
@NoArgsConstructor
public class CompraDTO extends CompraEntity {

    public CompraDTO(CompraEntity entity) {
        setId(entity.getId());
        setCantidad(entity.getCantidad());
        setPrecio(entity.getPrecio());
        setArticulo(entity.getArticulo());
        setFactura(entity.getFactura());
    }
}
