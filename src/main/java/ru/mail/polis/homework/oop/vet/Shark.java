package ru.mail.polis.homework.oop.vet;

public class Shark extends Animal implements WildAnimal{

    private String organizationName;
    private MoveType moveType;

    @Override
    public String say() {
        return "Clack Clack";
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }

    public Shark() {
        super(0);
        this.moveType = MoveType.SWIM;
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
