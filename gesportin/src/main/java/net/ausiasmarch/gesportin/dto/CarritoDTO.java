package net.ausiasmarch.gesportin.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.CarritoEntity;

@Getter
@Setter
@NoArgsConstructor
public class CarritoDTO extends CarritoEntity {

    private double precioTotal;

    public CarritoDTO(CarritoEntity entity) {
        setId(entity.getId());
        setCantidad(entity.getCantidad());
        setArticulo(entity.getArticulo());
        setUsuario(entity.getUsuario());
        this.precioTotal = calcularPrecioTotal(entity);
    }

    private static double calcularPrecioTotal(CarritoEntity entity) {
        BigDecimal precio = entity.getArticulo().getPrecio();
        BigDecimal descuento = entity.getArticulo().getDescuento();
        BigDecimal factor = descuento != null
                ? BigDecimal.ONE.subtract(descuento.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP))
                : BigDecimal.ONE;
        return precio.multiply(factor)
                .multiply(BigDecimal.valueOf(entity.getCantidad()))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
