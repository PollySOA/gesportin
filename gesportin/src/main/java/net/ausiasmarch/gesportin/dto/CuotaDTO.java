package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.CuotaEntity;

@Getter
@Setter
@NoArgsConstructor
public class CuotaDTO extends CuotaEntity {

    private int pagos;

    public CuotaDTO(CuotaEntity entity, int pagos) {
        setId(entity.getId());
        setDescripcion(entity.getDescripcion());
        setCantidad(entity.getCantidad());
        setFecha(entity.getFecha());
        setEquipo(entity.getEquipo());
        this.pagos = pagos;
    }
}
