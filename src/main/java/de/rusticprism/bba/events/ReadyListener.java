package de.rusticprism.bba.events;

import de.rusticprism.bba.BetterButtonApi;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.jetbrains.annotations.NotNull;

public class ReadyListener extends ListenerAdapter {
    private BetterButtonApi api;
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        this.api = new BetterButtonApi(event.getJDA());
        MessageCreateAction message = event.getJDA().getGuilds().get(0).getTextChannelById(967190164155805696L).sendMessage("Test");


        message.addActionRow(api.registerButton("Test", ButtonStyle.DANGER,dummy -> {
            System.out.println("Test");
            api.unregisterButton(1);
        }));

        message.addActionRow(api.registerDropDown("Test1", new String[]{"1", "2", "3"}, s -> {
            api.unregisterDropDown(1);
        }));

        message.queue();



    }
}
