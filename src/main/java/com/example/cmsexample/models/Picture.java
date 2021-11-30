package com.example.cmsexample.models;


import javax.persistence.*;

@Entity
@Table(name="pictures")
public class Picture {

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "hibernateSeq", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")
    private int id;

    @Column(name="data")
    @Lob
    private byte[] data;

    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
