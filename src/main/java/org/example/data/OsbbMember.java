package org.example.data;

public class OsbbMember {

    private int id;
    private String adress;
    private short numberFlat;
    private float square;
    private String name;
    private String contact;

    public int getId() {
        return id;
    }

    OsbbMember setId(int id) {
        this.id = id;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    OsbbMember setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public short getNumberFlat() {
        return numberFlat;
    }

    OsbbMember setNumberFlat(short numberFlat) {
        this.numberFlat = numberFlat;
        return this;
    }

    public float getSquare() {
        return square;
    }

    OsbbMember setSquare(float square) {
        this.square = square;
        return this;
    }

    public String getName() {
        return name;
    }

    OsbbMember setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    OsbbMember setContact(String contact) {
        this.contact = contact;
        return this;
    }

    @Override
    public String toString() {
        return getId() +
                ". " +
                getAdress() +
                ", " +
                getNumberFlat() +
                ", " +
                getSquare() +
                ", " +
                getName() +
                ", " +
                getContact() +
                "\r\n";
    }
}
