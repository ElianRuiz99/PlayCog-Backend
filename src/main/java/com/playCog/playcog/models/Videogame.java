package com.playCog.playcog.models;

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
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

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

    @OneToMany(mappedBy = "idVideogame", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progressesVideogame;

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

    public List<Progress> getProgressesVideogame() {
        return progressesVideogame;
    }
    public void setProgressesVideogame(List<Progress> progressesVideogame) {
        this.progressesVideogame = progressesVideogame;
    }
}
