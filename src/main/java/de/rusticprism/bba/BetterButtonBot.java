package de.rusticprism.bba;

import de.rusticprism.bba.events.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class BetterButtonBot {
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault("OTE3MTM1NjY4ODk4MDU0MjQ0.GKoQ9h.WowoEI86zlYG0XvckJ1r1jPZPlRVZukRKvXjQk")
                .setActivity(Activity.watching("StreamDK Bot"))
                .addEventListeners(new ReadyListener());
        JDA jda = builder.build();
    }
}