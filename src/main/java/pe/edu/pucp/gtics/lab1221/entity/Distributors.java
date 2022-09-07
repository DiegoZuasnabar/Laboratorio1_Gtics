package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "distribuidoras", schema = "gameshop3", catalog = "")
public class Distributors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddistribuidora")
    private int iddistribuidora;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "fundacion")
    private int fundacion;
    @Basic
    @Column(name = "sede")
    private String sede;

    public int getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(int iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
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

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distributors that = (Distributors) o;
        return iddistribuidora == that.iddistribuidora && fundacion == that.fundacion && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(sede, that.sede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddistribuidora, nombre, descripcion, fundacion, sede);
    }
}
