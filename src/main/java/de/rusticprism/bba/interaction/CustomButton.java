package de.rusticprism.bba.interaction;

import de.rusticprism.bba.util.Dummy;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

import java.util.function.Consumer;

public class CustomButton {
    private final int id;
    private final String name;
    private final Consumer<Dummy> consumer;
    private final Button button;
    private ButtonInteraction interaction;
    public CustomButton(int id, String name, Button button, Consumer<Dummy> consumer) {
        this.id = id;
        this.name = name;
        this.consumer = consumer;
        this.button = button;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Consumer<Dummy> getConsumer() {
        return consumer;
    }

    public Button getButton() {
        return button;
    }
    public void setInteraction(ButtonInteraction interaction) {
        this.interaction = interaction;
    }

    public ButtonInteraction getInteraction() {
        return interaction;
    }
}
