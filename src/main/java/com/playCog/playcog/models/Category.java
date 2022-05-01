package com.playCog.playcog.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "categoria_seq_generator")
    @SequenceGenerator(
            name = "categoria_seq_generator",
            sequenceName = "categoria_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "idCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Videogame> videogames;

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

    public List<Videogame> getVideogames() {
        return videogames;
    }
    public void setVideogames(List<Videogame> videogames) {
        this.videogames = videogames;
    }
}
