package com.saed.dev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity // Essa anotação indica que a classe é uma entidade do JPA
@Table(name = "tb_payment") // Essa anotação indica que a classe é uma tabela do banco de dados
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Essa anotação indica que o atributo é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação indica que o atributo é auto incrementável
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
