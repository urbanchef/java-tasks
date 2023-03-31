package ru.mail.polis.homework.oop.vet;

public class Snake extends Animal implements WildAnimal {

    private MoveType moveType;
    private String organizationName;

    public Snake() {
        super(0);
        this.moveType = MoveType.CRAWL;
    }

    @Override
    public String say() {
        return "Shhhh";
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }

    @Override
    public String getOrganizationName() {
        return this.organizationName;
    }

    @Override
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
