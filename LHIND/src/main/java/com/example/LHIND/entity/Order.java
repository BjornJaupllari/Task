package com.example.LHIND.entity;

import com.example.LHIND.helper.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_user_fk", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @Column(name = "submitted_date")
    private Date submittedDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "deadline_date")
    private Date deadlineDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_truck",
            joinColumns = @JoinColumn(name = "order_id"),

            inverseJoinColumns = @JoinColumn(name = "truck_id"))
    private List<Truck> trucks;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

}
