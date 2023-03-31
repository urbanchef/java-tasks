package ru.mail.polis.homework.oop.vet;

public class Pigeon extends Animal implements WildAnimal{

    private String organizationName;
    private final MoveType moveType;

    public Pigeon() {
        super(2);
        this.moveType = MoveType.FLY;
    }

    @Override
    public String say() {
        return "curls-curls";
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
