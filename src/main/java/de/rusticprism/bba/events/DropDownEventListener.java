package de.rusticprism.bba.events;

import de.rusticprism.bba.BetterButtonApi;
import de.rusticprism.bba.interaction.DropDown;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DropDownEventListener extends ListenerAdapter {
    private final BetterButtonApi api;

    public DropDownEventListener(BetterButtonApi api) {
        this.api = api;
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        int id = Integer.parseInt(event.getComponentId().replaceAll("bba_dropdown_", ""));
        if(api.getDropdowns().keySet().contains(id)) {
            DropDown dropDown = api.getDropdowns().get(id);
            int dropid = Integer.parseInt(event.getValues().get(0).replaceAll("bba_dropdown_option_",""));
            dropDown.getConsumer().accept(dropDown.getOptions().get(dropid));
            event.editSelectMenu(dropDown.getMenu()).queue();
        }
    }
}
