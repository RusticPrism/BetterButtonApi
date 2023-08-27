package de.rusticprism.bba;

import de.rusticprism.bba.events.ButtonListener;
import de.rusticprism.bba.events.DropDownEventListener;
import de.rusticprism.bba.interaction.CustomButton;
import de.rusticprism.bba.interaction.DropDown;
import de.rusticprism.bba.util.Dummy;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.HashMap;
import java.util.function.Consumer;

public class BetterButtonApi {
    private final HashMap<Integer, DropDown> dropdowns;
    private final HashMap<Integer, CustomButton> buttons;
    private int dropdownid = 0;
    private int buttonid = 0;
    private final JDA jda;
    public BetterButtonApi(JDA jda) {
        this.jda = jda;
        this.dropdowns = new HashMap<>();
        this.buttons = new HashMap<>();
        registerEvents();
    }
    private void registerEvents() {
        jda.addEventListener(new DropDownEventListener(this));
        jda.addEventListener(new ButtonListener(this));
    }
    public Button registerButton(String text, ButtonStyle style, Consumer<Dummy> consumer) {
        buttonid = buttonid + 1;
        Button button = Button.of(style, "bba_button_" + buttonid, text);
        buttons.put(buttonid, new CustomButton(buttonid, text, button, consumer));
        return button;
    }
    public void unregisterButton(int id) {
        Button button = buttons.get(id).getButton();
        CustomButton customButton = buttons.get(id);
        if(customButton.getInteraction() != null) {
            customButton.getInteraction().editButton(button.asDisabled()).queue();
        }
    }
    public StringSelectMenu registerDropDown(String placeholder, String[] options, Consumer<String> consumer) {
        System.out.println("Register");
        dropdownid = dropdownid + 1;
        StringSelectMenu.Builder menu = StringSelectMenu.create("bba_dropdown_" + dropdownid);
        menu.setPlaceholder(placeholder);
        for (int i = 0; i < options.length; i++) {
            menu.addOption(options[i],"bba_dropdown_option_" + i);
        }
        dropdowns.put(dropdownid, new DropDown(dropdownid,placeholder,options,consumer, menu.build()));
        return menu.build();
    }
    public void unregisterDropDown(int id) {
        StringSelectMenu menu = dropdowns.get(id).getMenu();
        DropDown dropDown = dropdowns.get(id);
        if(dropDown.getInteraction() != null) {
            dropDown.getInteraction().editSelectMenu(menu.asDisabled()).queue();
        }
    }

    public HashMap<Integer, DropDown> getDropdowns() {
        return dropdowns;
    }

    public HashMap<Integer, CustomButton> getButtons() {
        return buttons;
    }
}
