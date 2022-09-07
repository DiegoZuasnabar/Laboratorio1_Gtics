package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plataformas")
public class Platforms {
    @Id
    @Column(name = "idplataforma", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}