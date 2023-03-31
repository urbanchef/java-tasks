package ru.mail.polis.homework.oop.vet;

public class Dog extends Animal implements Pet {

    private MoveType moveType;

    public Dog() {
        super(4);
        this.moveType = MoveType.RUN;
    }

    @Override
    public String say() {
        return "Wow-wow";
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }
}
