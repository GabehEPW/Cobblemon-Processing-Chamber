package com.nbp.processing_chamber.client.screen

import com.nbp.processing_chamber.ProcessingChamber
import com.nbp.processing_chamber.menu.ProcessingChamberMenu
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory
import kotlin.math.ceil

class ProcessingChamberScreen(
    menu: ProcessingChamberMenu,
    inventory: Inventory,
    title: Component,
) : AbstractContainerScreen<ProcessingChamberMenu>(menu, inventory, title) {

    init {
        imageWidth = WIDTH
        imageHeight = HEIGHT
        titleLabelY = 8
        inventoryLabelX = 15
        inventoryLabelY = 104
    }

    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTick)
        super.render(guiGraphics, mouseX, mouseY, partialTick)
        renderMeterTooltip(guiGraphics, mouseX, mouseY)
        renderTooltip(guiGraphics, mouseX, mouseY)
    }

    override fun renderBg(guiGraphics: GuiGraphics, partialTick: Float, mouseX: Int, mouseY: Int) {
        val left = leftPos
        val top = topPos

        guiGraphics.blit(BACKGROUND, left, top, 0F, 0F, WIDTH, HEIGHT, WIDTH, HEIGHT)
        renderEnergy(guiGraphics, left, top)
        renderProgress(guiGraphics, left, top)
    }

    override fun renderLabels(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int) {
        val titleX = ((imageWidth - font.width(title)) / 2).coerceAtLeast(0)
        guiGraphics.drawString(font, title, titleX, titleLabelY, 0xFFFFFF, true)
        // The custom background already frames the player inventory, so no label is needed here.
    }

    private fun renderEnergy(guiGraphics: GuiGraphics, left: Int, top: Int) {
        val frame = if (menu.capacity <= 0) {
            BATTERY_FRAMES - 1
        } else {
            val energy = menu.energy.coerceIn(0, menu.capacity)
            when {
                energy <= 0 -> 4
                energy >= menu.capacity -> 0
                energy <= menu.capacity * 0.25f -> 3
                energy <= menu.capacity * 0.50f -> 2
                else -> 1
            }
        }

        guiGraphics.blit(
            BATTERY,
            left + BATTERY_X,
            top + BATTERY_Y,
            0F,
            (frame * BATTERY_HEIGHT).toFloat(),
            BATTERY_WIDTH,
            BATTERY_HEIGHT,
            BATTERY_WIDTH,
            BATTERY_HEIGHT * BATTERY_FRAMES,
        )
    }

    private fun renderProgress(guiGraphics: GuiGraphics, left: Int, top: Int) {
        val frame = if (menu.processTime <= 0) {
            0
        } else {
            val filledRatio = menu.progress.coerceIn(0, menu.processTime) / menu.processTime.toFloat()
            ceil(filledRatio * (PROGRESS_FRAMES - 1))
                .toInt()
                .coerceIn(0, PROGRESS_FRAMES - 1)
        }

        guiGraphics.blit(
            PROGRESS,
            left + PROGRESS_X,
            top + PROGRESS_Y,
            0F,
            (frame * PROGRESS_HEIGHT).toFloat(),
            PROGRESS_WIDTH,
            PROGRESS_HEIGHT,
            PROGRESS_WIDTH,
            PROGRESS_HEIGHT * PROGRESS_FRAMES,
        )
    }

    private fun renderMeterTooltip(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int) {
        val localX = mouseX - leftPos
        val localY = mouseY - topPos

        if (localX in BATTERY_X until BATTERY_X + BATTERY_WIDTH &&
            localY in BATTERY_Y until BATTERY_Y + BATTERY_HEIGHT
        ) {
            guiGraphics.renderComponentTooltip(
                font,
                listOf(
                    Component.literal("${menu.energy} / ${menu.capacity} FE/RF"),
                    Component.literal("${menu.energyPerTick} FE/RF/t"),
                ),
                mouseX,
                mouseY,
            )
            return
        }

        if (isProgressFrameHovered(localX, localY)) {
            val visibleProgress = menu.progress.coerceIn(0, menu.processTime)
            guiGraphics.renderComponentTooltip(
                font,
                listOf(
                    Component.literal("$visibleProgress / ${menu.processTime}"),
                    Component.literal("${menu.energyPerTick} FE/RF/t"),
                    Component.literal("Fortune: ${menu.fortuneChancePercent}%"),
                ),
                mouseX,
                mouseY,
            )
        }
    }

    private fun isProgressFrameHovered(localX: Int, localY: Int): Boolean {
        if (localX !in PROGRESS_X until PROGRESS_X + PROGRESS_WIDTH ||
            localY !in PROGRESS_Y until PROGRESS_Y + PROGRESS_HEIGHT
        ) {
            return false
        }

        val frameX = localX - PROGRESS_X
        val frameY = localY - PROGRESS_Y
        return frameX < PROGRESS_TOOLTIP_BORDER ||
            frameX >= PROGRESS_WIDTH - PROGRESS_TOOLTIP_BORDER ||
            frameY < PROGRESS_TOOLTIP_BORDER ||
            frameY >= PROGRESS_HEIGHT - PROGRESS_TOOLTIP_BORDER
    }

    companion object {
        private const val WIDTH = 192
        private const val HEIGHT = 198

        private const val BATTERY_X = 18
        private const val BATTERY_Y = 55
        private const val BATTERY_WIDTH = 19
        private const val BATTERY_HEIGHT = 29
        private const val BATTERY_FRAMES = 5

        private const val PROGRESS_X = 59
        private const val PROGRESS_Y = 32
        private const val PROGRESS_WIDTH = 74
        private const val PROGRESS_HEIGHT = 74
        private const val PROGRESS_FRAMES = 85
        private const val PROGRESS_TOOLTIP_BORDER = 8

        private fun resource(path: String): ResourceLocation =
            ResourceLocation.fromNamespaceAndPath(ProcessingChamber.MOD_ID, path)

        private val BACKGROUND = resource("textures/gui/interfaceprocessingchamber.png")
        private val BATTERY = resource("textures/gui/modelobateria.png")
        private val PROGRESS = resource("textures/gui/modelocarregamento.png")
    }
}
