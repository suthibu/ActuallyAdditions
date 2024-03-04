/*
 * This file ("GuiRangedCollector.java") is part of the Actually Additions mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2015-2017 Ellpeck
 */

package de.ellpeck.actuallyadditions.mod.inventory.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import de.ellpeck.actuallyadditions.mod.inventory.ContainerRangedCollector;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityRangedCollector;
import de.ellpeck.actuallyadditions.mod.util.AssetUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;


@OnlyIn(Dist.CLIENT)
public class GuiRangedCollector extends AAScreen<ContainerRangedCollector> {

    private static final ResourceLocation RES_LOC = AssetUtil.getGuiLocation("gui_ranged_collector");
    private final TileEntityRangedCollector collector;

    private FilterSettingsGui filter;

    public GuiRangedCollector(ContainerRangedCollector container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.collector = container.collector;
        this.imageWidth = 176;
        this.imageHeight = 86 + 86;
    }

    @Override
    public void init() {
        super.init();

        //this.filter = new FilterSettingsGui(this.collector.filter, this.leftPos + 3, this.topPos + 6, this.buttonList);
    }

    @Override
    public void render(@Nonnull GuiGraphics guiGraphics, int x, int y, float f) {
        super.render(guiGraphics, x, y, f);

        //this.filter.drawHover(matrices, x, y);
    }

    @Override
    public void containerTick() {
        super.containerTick();

        this.filter.tick();
    }

    @Override
    public void renderBg(GuiGraphics guiGraphics, float f, int x, int y) {
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);

        guiGraphics.blit(AssetUtil.GUI_INVENTORY_LOCATION, this.leftPos, this.topPos + 86, 0, 0, 176, 86);

        guiGraphics.blit(RES_LOC, this.leftPos, this.topPos, 0, 0, 176, 86);
    }

//    @Override
//    public void actionPerformed(Button button) {
//        PacketHandlerHelper.sendButtonPacket(this.collector, button.id);
//    }
}
