package net.ausiasmarch.gesportin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ausiasmarch.gesportin.entity.TipoarticuloEntity;

public interface TipoarticuloRepository extends JpaRepository<TipoarticuloEntity, Long> {

    Page<TipoarticuloEntity> findByDescripcionContainingIgnoreCase(String descripcion, Pageable oPageable);

    Page<TipoarticuloEntity> findByClubId(Long idClub, Pageable oPageable);

    Page<TipoarticuloEntity> findByDescripcionContainingIgnoreCaseAndClubId(String descripcion, Long clubId, Pageable oPageable);

    @Query("SELECT COUNT(a) FROM ArticuloEntity a WHERE a.tipoarticulo.id = :id")
    int countArticulosByTipoarticuloId(@Param("id") Long id);
}
