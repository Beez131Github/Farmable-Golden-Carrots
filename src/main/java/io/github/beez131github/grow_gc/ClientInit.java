package io.github.beez131github.grow_gc;

import io.github.beez131github.grow_gc.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.text.Text;

import java.util.concurrent.CompletableFuture;

public class ClientInit implements ClientModInitializer {
	private static final DisconnectionDetails SERVER_MISSING_MOD = new DisconnectionDetails(Text.translatable(
		"multiplayer.grow_gc.disconnect.server_missing_mod"
	));

	private static boolean validServer;

	@Override
	public void onInitializeClient() {
		ClientLoginConnectionEvents.QUERY_START.register((handler, client) -> validServer = false);

		ClientLoginNetworking.registerGlobalReceiver(
			GrowGc.VERIFICATION_CHANNEL,
			(client, handler, buf, listenerAdder) -> {
				validServer = true;
				return CompletableFuture.completedFuture(PacketByteBufs.empty());
			}
		);

		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
			if (!validServer) {
				handler.onDisconnected(SERVER_MISSING_MOD);
			}
		});

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_CARROT_CROP, RenderLayer.getCutout());
		System.out.println("Growable golden carrots initialized!");
	}
}
