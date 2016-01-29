# ItemCreator
bukkit/spigot plugin to create / spawn custom items

### Installation

Move the JAR to the /plugins directory of your server or build the JAR yourself from the included source.

### Usage

This plugin is heavily dependent on configuration.  In your `/plugins/ItemCreator/config.yml` file you are able to
add as many new items as you like. (see the config schema in the table below)

After you've configured your item you can then run the command `/ic spawn <item_id>` in your minecraft console and
the server will place your spawned custom item in an empty inventory slot.

### Configuration

| Key           | Required      | Description       | Type   | Example | Default |
| ------------- | ------------- | ----------------- | ------ | ------- | ------- |
| item_id       | Yes           | unique identifier | String | "cool_sword" | |
| name          | Yes           | Display Name      | String | "Super Awesome Sword" | |
| material      | Yes           | Item Type         | STRING | "GOLD_SWORD" | |
| stack_size    | No            | Amount on Stack   | Int    | 5 | 1 |
| enchantments  | No            | List of Enchantments | List | See Below | |
| enchantments.name | Yes       | Name of Enchantment | STRING | "DAMAGE_ALL" | | 
| enchantments.level | No       | Level of Enchantment | Int | 1 | Lowest Available |
| lore          | No            | Addition text about object | List | See Below* |

*Lore is just a list of strings


### Example

#### plugins/ItemCreator/config.yml

```yaml
items:
  - name: "Jack's Epic Blade of Awesomeness!"
    item_id: "epic_blade"
    material: GOLD_SWORD
    enchantments:
      - name: DAMAGE_ALL
      - name: FIRE_ASPECT
        level: 2
    lore:
      - "First Line of Lore!"
      - "     Another Lore"
    stack_Size: 1
```
#### Command
![Command](http://static.joel.io/ss1.png)

#### Item
![Item](http://static.joel.io/ss2.png)
