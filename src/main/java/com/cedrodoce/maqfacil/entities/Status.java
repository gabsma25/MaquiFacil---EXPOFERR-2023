package com.cedrodoce.maqfacil.entities;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank
    private boolean em_uso;
    @Column
    @NotBlank
    private Integer nivel_oleo;

    @Column
    @NotBlank
    private Integer nivel_combustivel;
    @Column
    private Date ultima_manutencao;

    public Status(Long id, boolean em_uso, Integer nivel_oleo, Integer nivel_combustivel, Date ultima_manutencao) {
        this.id = id;
        this.em_uso = em_uso;
        this.nivel_oleo = nivel_oleo;
        this.nivel_combustivel = nivel_combustivel;
        this.ultima_manutencao = ultima_manutencao;
    }

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEm_uso() {
        return em_uso;
    }

    public void setEm_uso(boolean em_uso) {
        this.em_uso = em_uso;
    }

    public Integer getNivel_oleo() {
        return nivel_oleo;
    }

    public void setNivel_oleo(Integer nivel_oleo) {
        this.nivel_oleo = nivel_oleo;
    }

    public Integer getNivel_combustivel() {
        return nivel_combustivel;
    }

    public void setNivel_combustivel(Integer nivel_combustivel) {
        this.nivel_combustivel = nivel_combustivel;
    }

    public Date getUltima_manutencao() {
        return ultima_manutencao;
    }

    public void setUltima_manutencao(Date ultima_manutencao) {
        this.ultima_manutencao = ultima_manutencao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", em_uso=" + em_uso +
                ", nivel_oleo=" + nivel_oleo +
                ", nivel_combustivel=" + nivel_combustivel +
                ", ultima_manutencao=" + ultima_manutencao +
                '}';
    }
}
