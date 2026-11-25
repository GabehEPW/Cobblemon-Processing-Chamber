![Banner](https://i.imgur.com/LsSC0y9.png)

# Processing Chamber

**Processing Chamber** is a **Cobblemon addon** that adds FE/RF-powered machines for automating the production of **Apricorns**, **Berries**, **Mint Leaves**, seed-grown Minecraft crops, and Cobblemon plants.

Build compact processing setups, power your machines with FE/RF, install upgrade cards, and automate resource production using hoppers, item pipes, and energy networks.

---

## ✨ Features

* FE/RF-powered processing machines
* Apricorn Seed automation
* Berry multiplication
* Mint Leaf production
* Upgrade cards with unique effects
* Advanced machine tier
* Custom GUI
* Energy and progress display
* Hopper and pipe automation support
* Configurable machine values

---

## 🔧 Blocks

| Block                           | Description                                                                                                                                              |
| ------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Resource Chamber**          | Basic machine for processing Cobblemon resources. Stores **5,000 FE/RF**, consumes **15 FE/RF/t**, and accepts **1 upgrade card**.                             |
| **Advanced Resource Chamber** | Advanced machine with higher energy capacity, faster processing, and up to **3 different upgrade cards**. Stores **10,000 FE/RF** and consumes **45 FE/RF/t**. |

---

## 🧩 Items

| Item                      | Description                                                                                                               |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **Processor Upgrade Kit** | Upgrades a Resource Chamber into an Advanced Resource Chamber while preserving energy, progress, items, and upgrades. |
| **Overclock Card**        | Reduces processing time, but increases FE/RF usage.                                                                       |
| **Optimized Card**        | Reduces FE/RF consumption without changing processing time.                                                                  |
| **Fortune Card**          | Adds a chance to generate bonus output, but increases FE/RF usage.                                                        |

---

## ⚙️ How It Works

1. Place a **Resource Chamber** or **Advanced Resource Chamber** in the world.
2. Supply FE/RF energy through the **back face** of the machine.
3. Insert a valid item into the input slot.
4. The machine processes automatically while it has energy and output space.
5. Generated items are stored in the **8 output slots** around the input slot.
6. Outputs can be collected manually, extracted through automation, or pushed into an inventory below.

The input item is **not consumed every cycle**.

It stays inside the machine and continues producing resources until:

* The output slots are full
* The machine runs out of energy
* The player removes the input item

If the machine runs out of energy, the processing progress is paused instead of being reset.

---

## ⬆️ Processor Upgrade Kit

The **Processor Upgrade Kit** instantly converts a **Resource Chamber** into an **Advanced Resource Chamber**.

The upgrade preserves:

* Stored energy
* Processing progress
* Input item
* Output items
* Upgrade cards

---

## 🃏 Upgrade Cards

Upgrade cards can only be inserted into upgrade slots.

### Upgrade Rules

* **Resource Chamber** accepts **1 upgrade card**
* **Advanced Resource Chamber** accepts up to **3 different upgrade cards**
* Duplicate upgrade cards are not allowed in the same machine
* Each upgrade slot holds only **1 card**

---

### Overclock Card

Increases machine speed.

**Effects:**

* Reduces processing time by **20%**
* Increases FE/RF consumption by **40%**

---

### Optimized Card

Improves energy efficiency.

**Effects:**

* Reduces FE/RF consumption by **30%**
* Does not change processing time

---

### Fortune Card

Adds a chance to generate bonus output.

**Effects:**

* **+15%** bonus output chance in the Resource Chamber
* **+25%** bonus output chance in the Advanced Resource Chamber
* Increases FE/RF consumption by **20%**

---

## 📋 Supported Processing

### Apricorn Seeds & Sprouts → Apricorns

Supports both legacy Apricorn Seeds and Cobblemon 1.8+ Apricorn Sprouts.

| Input                                            | Output          |
| ------------------------------------------------ | --------------- |
| Black Apricorn Seed / Black Apricorn Sprout     | Black Apricorn  |
| Blue Apricorn Seed / Blue Apricorn Sprout       | Blue Apricorn   |
| Green Apricorn Seed / Green Apricorn Sprout     | Green Apricorn  |
| Pink Apricorn Seed / Pink Apricorn Sprout       | Pink Apricorn   |
| Red Apricorn Seed / Red Apricorn Sprout         | Red Apricorn    |
| White Apricorn Seed / White Apricorn Sprout     | White Apricorn  |
| Yellow Apricorn Seed / Yellow Apricorn Sprout   | Yellow Apricorn |

---

### Berries → Same Berry

Supported Cobblemon berries can be processed into the same berry type, making berry multiplication easy to automate.

Example:

| Input        | Output       |
| ------------ | ------------ |
| Oran Berry   | Oran Berry   |
| Sitrus Berry | Sitrus Berry |
| Pecha Berry  | Pecha Berry  |

---

### Mint Seeds → Mint Leaves

Supports both plural (`*_mint_seeds`) and singular (`*_mint_seed`) variants.

| Input                                   | Output          |
| --------------------------------------- | --------------- |
| Red Mint Seeds / Red Mint Seed          | Red Mint Leaf   |
| Blue Mint Seeds / Blue Mint Seed        | Blue Mint Leaf  |
| Green Mint Seeds / Green Mint Seed      | Green Mint Leaf |
| Pink Mint Seeds / Pink Mint Seed        | Pink Mint Leaf  |
| White Mint Seeds / White Mint Seed      | White Mint Leaf |
| Cyan Mint Seeds / Cyan Mint Seed        | Cyan Mint Leaf  |

---

### Minecraft Seeds and Crops → Mature Crop

Processed foods are not accepted directly. Only crop seeds or crop items that act as their own seed can be processed.

Examples:

| Input          | Output       |
| -------------- | ------------ |
| Wheat Seeds    | Wheat        |
| Beetroot Seeds | Beetroot     |
| Melon Seeds    | Melon Slice  |
| Pumpkin Seeds  | Pumpkin      |
| Pumpkin        | Pumpkin      |
| Apple          | Apple        |
| Carrot         | Carrot       |
| Potato         | Potato       |

---

### Cobblemon Plants & Crops → Same Item

Items in `#cobblemon:plants` and common Cobblemon ingredients can be processed into the same item type, making medicinal materials and herbs easy to farm.

| Input                               | Output         |
| ----------------------------------- | -------------- |
| Vivichoke Seeds / Vivichoke Seed    | Vivichoke      |
| Hearty Grains                       | Hearty Grains  |
| Medicinal Leek                      | Medicinal Leek |
| Big Root                            | Big Root       |
| Energy Root                         | Energy Root    |
| Revival Herb                        | Revival Herb   |
| Pep-Up Flower                       | Pep-Up Flower  |
| Galarica Nut                        | Galarica Nut   |

---

## ⚡ Energy

Processing Chamber machines use **FE/RF energy**.

| Parameter            | Resource Chamber | Advanced Resource Chamber |
| -------------------- | -----------------: | --------------------------: |
| Energy storage       |           5,000 FE/RF |                   10,000 FE/RF |
| Base FE/RF consumption  |            15 FE/RF/t |                     45 FE/RF/t |
| Base processing time |  1,800 ticks / 90s |             900 ticks / 45s |
| Output slots         |                  8 |                           8 |
| Upgrade slots        |                  1 |                           3 |

Energy is inserted through the **back face** of the machine.

Stored energy is preserved when the machine is broken and placed again.

---

## 🔨 Crafting Recipes

### Resource Chamber

```txt
I I I
G R G
I I I
```

```txt
I: Iron Ingot
G: Glass
R: Redstone
```

---

### Advanced Resource Chamber

```txt
O R O
Q P Q
O R O
```

```txt
O: Obsidian
R: Redstone
Q: Quartz
P: Resource Chamber
```

---

### Processor Upgrade Kit

```txt
O R O
Q O Q
O R O
```

```txt
O: Obsidian
R: Redstone
Q: Quartz
```

---

### Overclock Card

```txt
R S R
G C G
R S R
```

```txt
R: Redstone
S: Sugar
G: Gold Ingot
C: Copper Ingot
```

---

### Optimized Card

```txt
C L C
R G R
C L C
```

```txt
C: Copper Ingot
L: Lapis Lazuli
R: Redstone
G: Glass Pane
```

---

### Fortune Card

```txt
A Y A
N R N
A Y A
```

```txt
A: Any Cobblemon Apricorn
Y: Any Cobblemon Berry
N: Gold Nugget
R: Redstone
```

---

## ⬇️ Automation

Processing Chamber machines support automation with hoppers, item pipes, and energy networks.

| Side   | Function                        |
| ------ | ------------------------------- |
| Top    | Inserts valid input items       |
| Bottom | Extracts generated output items |
| Back   | Accepts FE/RF energy               |

Machines can also transfer outputs downward into another chamber or a vanilla inventory placed below them, such as a chest or barrel.

This allows players to build compact vertical processing arrays.

---

## 🎨 Visuals

The machines include:

* Detailed 3D block models
* Custom GUI
* Animated internal item rendering
* Visual energy bar
* Visual progress bar
* Colored machine and upgrade names
* Tooltips showing useful machine information

Tooltips may display:

* Stored energy
* Processing progress
* FE/RF/t usage
* Fortune bonus chance
* Installed upgrade effects

---

## ⚙️ Configuration

The mod creates a configuration file at:

```txt
config/processing_chamber.json
```

Server owners and players can configure:

* Max energy storage
* FE/RF consumption per tick
* Processing time
* Output amount
* Upgrade slot count
* Minimum processing time
* Fortune bonus chance
* Upgrade card multipliers
* Minimum FE/RF/t usage
* Tag-based processing rules
* Custom input/output processing rules

Example configuration:

```json
{
  "normal": {
    "max_energy": 5000,
    "energy_per_tick": 15,
    "process_time": 1800,
    "output_amount": 1,
    "upgrade_slots": 1,
    "min_process_time": 1200,
    "fortune_bonus_chance": 0.15
  },
  "advanced": {
    "max_energy": 10000,
    "energy_per_tick": 45,
    "process_time": 900,
    "output_amount": 1,
    "upgrade_slots": 3,
    "min_process_time": 600,
    "fortune_bonus_chance": 0.25
  },
  "upgrades": {
    "overclock_time_multiplier": 0.8,
    "overclock_energy_multiplier": 1.4,
    "optimization_energy_multiplier": 0.7,
    "fortune_energy_multiplier": 1.2,
    "min_energy_per_tick": 5
  },
  "tag_processing": {
    "#cobblemon:plants": "same",
    "#cobblemon:berries": "same",
    "#cobblemon:apricorns": "same"
  },
  "custom_processing": {
    "cobblemon:vivichoke_seeds": "cobblemon:vivichoke",
    "minecraft:beetroot_seeds": "minecraft:beetroot"
  }
}
```

### Tag Processing

`tag_processing` lets servers process every item inside an item tag.

Use `"same"` to output the same item that was inserted, or use an item ID to make every item in that tag output a specific item.

Example:

```json
{
  "#cobblemon:berries": "same",
  "#cobblemon:apricorns": "minecraft:bone_meal"
}
```

### Custom Processing

`custom_processing` lets servers add any input/output pair without updating the mod.

Example:

```json
{
  "cobblemon:vivichoke_seeds": "cobblemon:vivichoke",
  "some_mod:custom_seed": "some_mod:custom_crop",
  "some_mod:duplicate_me": "same"
}
```

## 📦 Dependencies

### Common

* Minecraft **1.21.1**
* Cobblemon

### Fabric

* Fabric Loader
* Fabric API
* Fabric Language Kotlin
* TeamReborn Energy

### NeoForge

* NeoForge
* Kotlin for Forge

---

## 📜 License

This project is licensed under the **MIT License**.

Copyright © 2026 **GabehEPW**
