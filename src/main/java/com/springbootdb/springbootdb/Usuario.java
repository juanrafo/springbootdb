package com.springbootdb.springbootdb;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "estado")
    private String estado;
    @Column(name = "password")
    private String password;
    @Column(name = "usuario")
    private String usuario;

    public Usuario() {  }

    public Usuario(String usuario, String password, String estado) {
        this.setUsuario(usuario);
        this.setPassword(password);
        this.setEstado(estado);
    }

    public Usuario(int id, String usuario, String password , String estado) {
        this.setId(id);
        this.setUsuario(usuario);
        this.setPassword(password);
        this.setEstado(estado);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEstado() {
        return estado;
    }

    public String getUsuario() {
        return usuario;
    }


    @Override
    public String toString() {
        return "com.springbootdb.springbootdb.Usuario{" +
                "id=" + id +
                ", Usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
