package com.playCog.playcog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "videojuego")
public class Videogame {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "videojuego_seq_generator")
    @SequenceGenerator(
            name = "videojuego_seq_generator",
            sequenceName = "videojuego_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "link")
    private String link;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_categoria",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "videojuego_categoria_fkey",
                        foreignKeyDefinition = "FOREIGN KEY (id_categoria)\r\n" +
                        "REFERENCES public.\"categoria\" (id) MATCH SIMPLE\r\n" +
                        "ON UPDATE CASCADE\r\n" +
                        "ON DELETE CASCADE",
                        value = ConstraintMode.CONSTRAINT
                )
    )
    private Category idCategory;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public Category getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
