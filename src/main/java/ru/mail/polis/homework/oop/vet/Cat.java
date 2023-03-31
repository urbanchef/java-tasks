package ru.mail.polis.homework.oop.vet;

public class Cat extends Animal implements Pet {

    private final MoveType moveType;

    public Cat() {
        super(4);
        this.moveType = MoveType.RUN;
    }

    @Override
    public String say() {
        return "Mow-Mow";
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }

}
