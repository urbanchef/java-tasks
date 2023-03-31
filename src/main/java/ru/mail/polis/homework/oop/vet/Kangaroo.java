package ru.mail.polis.homework.oop.vet;

public class Kangaroo extends Animal implements WildAnimal {

    private String organizationName;
    private MoveType moveType;

    @Override
    public String say() {
        return "Shha";
    }

    public Kangaroo() {
        super(2);
        this.moveType = MoveType.JUMP;
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }


    @Override
    public String getOrganizationName() {
        return organizationName;
    }

    @Override
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
