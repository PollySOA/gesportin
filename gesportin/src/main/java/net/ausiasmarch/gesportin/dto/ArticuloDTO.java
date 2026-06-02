package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.ArticuloEntity;

@Getter
@Setter
@NoArgsConstructor
public class ArticuloDTO extends ArticuloEntity {

    private int comentarioarts;
    private int puntuacionarts;
    private int compras;
    private int carritos;
    private double mediaPuntuacion;

    public ArticuloDTO(ArticuloEntity entity, int comentarioarts, int puntuacionarts,
            int compras, int carritos, double mediaPuntuacion) {
        setId(entity.getId());
        setDescripcion(entity.getDescripcion());
        setPrecio(entity.getPrecio());
        setDescuento(entity.getDescuento());
        setImagen(entity.getImagen());
        setTipoarticulo(entity.getTipoarticulo());
        this.comentarioarts = comentarioarts;
        this.puntuacionarts = puntuacionarts;
        this.compras = compras;
        this.carritos = carritos;
        this.mediaPuntuacion = mediaPuntuacion;
    }
}
