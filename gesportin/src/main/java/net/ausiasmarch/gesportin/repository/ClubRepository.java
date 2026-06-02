package net.ausiasmarch.gesportin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ausiasmarch.gesportin.entity.ClubEntity;

public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

    @Query("SELECT COUNT(t) FROM TemporadaEntity t WHERE t.club.id = :id")
    int countTemporadasByClubId(@Param("id") Long id);

    @Query("SELECT COUNT(n) FROM NoticiaEntity n WHERE n.club.id = :id")
    int countNoticiasByClubId(@Param("id") Long id);

    @Query("SELECT COUNT(ta) FROM TipoarticuloEntity ta WHERE ta.club.id = :id")
    int countTipoarticulosByClubId(@Param("id") Long id);

    @Query("SELECT COUNT(u) FROM UsuarioEntity u WHERE u.club.id = :id")
    int countUsuariosByClubId(@Param("id") Long id);
}
