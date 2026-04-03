package net.ausiasmarch.gesportin.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.gesportin.entity.PuntuacionartEntity;

public interface PuntuacionartRepository extends JpaRepository<PuntuacionartEntity, Long> {

    Page<PuntuacionartEntity> findByArticuloId(Long id_articulo, Pageable pageable);

    Page<PuntuacionartEntity> findByUsuarioId(Long id_usuario, Pageable pageable);

    Page<PuntuacionartEntity> findByArticuloTipoarticuloClubId(Long clubId, Pageable pageable);

    Optional<PuntuacionartEntity> findByArticuloIdAndUsuarioId(Long articuloId, Long usuarioId);

    boolean existsByArticuloIdAndUsuarioId(Long articuloId, Long usuarioId);
}
