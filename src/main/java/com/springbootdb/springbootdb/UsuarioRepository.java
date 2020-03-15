package com.springbootdb.springbootdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT id,estado,password,usuario FROM usuario u WHERE u.usuario = :usuario AND u.password= :password AND u.estado='activo'" , nativeQuery=true)
    List<Usuario> loguear(@Param("usuario") String usuario,@Param("password") String password);
}
