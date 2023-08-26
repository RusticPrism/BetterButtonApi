package de.rusticprism.bba.events;

import de.rusticprism.bba.BetterButtonApi;
import de.rusticprism.bba.interaction.CustomButton;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonListener extends ListenerAdapter {

    private final BetterButtonApi api;

    public ButtonListener(BetterButtonApi api) {
        this.api = api;
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        int id = Integer.parseInt(event.getComponentId().replaceAll("bba_button_", ""));
        if(api.getButtons().containsKey(id))  {
            CustomButton button = api.getButtons().get(id);
            button.setInteraction(event.getInteraction());
            event.editButton(button.getButton()).queue();
        }
    }
}
