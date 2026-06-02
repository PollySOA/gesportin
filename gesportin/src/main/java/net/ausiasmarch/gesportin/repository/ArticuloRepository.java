package net.ausiasmarch.gesportin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ausiasmarch.gesportin.entity.ArticuloEntity;

public interface ArticuloRepository extends JpaRepository<ArticuloEntity, Long> {

    Page<ArticuloEntity> findByDescripcionContainingIgnoreCase(String descripcion, Pageable pageable);

    Page<ArticuloEntity> findByDescripcionContainingIgnoreCaseAndTipoarticuloClubId(String descripcion, Long clubId, Pageable pageable);

    Page<ArticuloEntity> findByTipoarticuloId(Long idTipoarticulo, Pageable pageable);

    // equipo-admin: only articles whose type belongs to club
    Page<ArticuloEntity> findByTipoarticuloClubId(Long clubId, Pageable pageable);

    @Query("SELECT COUNT(c) FROM ComentarioartEntity c WHERE c.articulo.id = :id")
    int countComentarioartsByArticuloId(@Param("id") Long id);

    @Query("SELECT COUNT(p) FROM PuntuacionartEntity p WHERE p.articulo.id = :id")
    int countPuntuacionartsByArticuloId(@Param("id") Long id);

    @Query("SELECT COUNT(co) FROM CompraEntity co WHERE co.articulo.id = :id")
    int countComprasByArticuloId(@Param("id") Long id);

    @Query("SELECT COUNT(ca) FROM CarritoEntity ca WHERE ca.articulo.id = :id")
    int countCarritosByArticuloId(@Param("id") Long id);

    @Query("SELECT COALESCE(AVG(p.puntuacion), 0.0) FROM PuntuacionartEntity p WHERE p.articulo.id = :id")
    double avgPuntuacionByArticuloId(@Param("id") Long id);
}
