package com.example.health.v7;

public class Symptom {
    private String text;

    public Symptom() {
    }

    public Symptom(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
