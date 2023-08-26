package de.rusticprism.bba.interaction;

import net.dv8tion.jda.api.interactions.components.selections.StringSelectInteraction;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.HashMap;
import java.util.function.Consumer;

public class DropDown {
    private final int id;
    private final String placeholder;
    private final HashMap<Integer, String> options;
    private final Consumer<String> consumer;
    private final StringSelectMenu menu;
    private StringSelectInteraction interaction;
    public DropDown(int id, String placeholder, String[] options, Consumer<String> consumer, StringSelectMenu menu) {
        this.id = id;
        this.placeholder = placeholder;
        this.options = new HashMap<>();
        for (int i = 0; i < options.length; i++) {
            this.options.put(i,options[i]);
        }
        this.consumer = consumer;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public Consumer<String> getConsumer() {
        return consumer;
    }

    public HashMap<Integer, String> getOptions() {
        return options;
    }

    public StringSelectMenu getMenu() {
        return menu;
    }

    public void setInteraction(StringSelectInteraction interaction) {
        this.interaction = interaction;
    }

    public StringSelectInteraction getInteraction() {
        return interaction;
    }
}
