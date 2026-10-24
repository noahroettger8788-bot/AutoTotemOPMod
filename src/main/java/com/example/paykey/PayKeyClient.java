package com.example.paykey;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class PayKeyClient implements ClientModInitializer {

    private static KeyBinding payW;
    private static KeyBinding payA;
    private static KeyBinding payS;
    private static KeyBinding payD;

    @Override
    public void onInitializeClient() {
        KeyBinding.Category category = KeyBinding.Category.create(Identifier.of("paykey", "main"));

        payW = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.paykey.pay_w", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_W, category));
        payA = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.paykey.pay_a", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_A, category));
        payS = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.paykey.pay_s", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_S, category));
        payD = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.paykey.pay_d", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_D, category));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (payW.wasPressed()) {
                client.player.networkHandler.sendChatCommand("pay g0ggY3909 8m");
            }
            while (payA.wasPressed()) {
                client.player.networkHandler.sendChatCommand("pay g0ggY3909 5m");
            }
            while (payS.wasPressed()) {
                client.player.networkHandler.sendChatCommand("pay g0ggY3909 7m");
            }
            while (payD.wasPressed()) {
                client.player.networkHandler.sendChatCommand("pay g0ggY3909 6m");
            }
        });
    }
}
