package net.ausiasmarch.gesportin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ausiasmarch.gesportin.entity.ClubEntity;

@Getter
@Setter
@NoArgsConstructor
public class ClubDTO extends ClubEntity {

    private int temporadas;
    private int noticias;
    private int tipoarticulos;
    private int usuarios;

    public ClubDTO(ClubEntity entity, int temporadas, int noticias, int tipoarticulos, int usuarios) {
        setId(entity.getId());
        setNombre(entity.getNombre());
        setDireccion(entity.getDireccion());
        setTelefono(entity.getTelefono());
        setFechaAlta(entity.getFechaAlta());
        setImagen(entity.getImagen());
        this.temporadas = temporadas;
        this.noticias = noticias;
        this.tipoarticulos = tipoarticulos;
        this.usuarios = usuarios;
    }
}
