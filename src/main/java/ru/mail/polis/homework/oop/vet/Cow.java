package ru.mail.polis.homework.oop.vet;

public class Cow extends Animal implements Pet {

    private MoveType moveType;


    public Cow() {
        super(4);
        this.moveType = MoveType.RUN;
    }

    @Override
    public String say() {
        return "Moo-Moo";
    }

    @Override
    public MoveType moveType() {
        return this.moveType;
    }

}
