package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.*;

@Entity
@Table(name = "juegos")
public class Games {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idjuego")
    private int id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgenero")
    private Genero idgenero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idplataforma")
    private Plataforma idplataforma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ideditora")
    private Editora ideditora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddistribuidora")
    private Distributors iddistribuidora;

    public int getId() {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Genero getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Genero idgenero) {
        this.idgenero = idgenero;
    }

    public Plataforma getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(Plataforma idplataforma) {
        this.idplataforma = idplataforma;
    }

    public Editora getIdeditora() {
        return ideditora;
    }

    public void setIdeditora(Editora ideditora) {
        this.ideditora = ideditora;
    }

    public Distributors getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(Distributors iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
    }

}