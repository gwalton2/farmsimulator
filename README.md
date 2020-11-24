# SER316 FarmSimulator
This system simulates a farm collective with various farmers, animals, and means of making money.
It implements the extra credit of having the design patterns work together to create a cohesive system that implements 9 requirements.

My system first allows you to specify if you want your farm to favor crops or animals. This means it will
start out with different base levels of acres(for crops) and pastures(for animals). Each time you level up your farm these increase by 1.
You can then choose the type of farmer you'd like your first farmer to be. You can choose between a crop grower and an animal rearer.
Crop growers increase the amount you make on each acre and animal rearers increase the amount you make when selling animal products.
When you level up your farmer these both increase as well as the salary of the farmer.
If your farmer is at level 5 or above, you can upgrade it to a rancher(Critter Whisperer or Corn Child depending on the time of farmer).
This futher buffs your farmer's stats as well as their salary.
You can also hire more farmers of different types.
You can also buy animals if you have enough pasture space. These animals can also be leveled up which increases what their product sells for
and what they can be sold for(removing them from your farm).
During the day you can enter one of these commands(all listed below).
During the night there is a 10% chance a wolf will eat one of your animals(removing it from the farm) and a 10% chance rabbits will eat some of your crops.
Each cycle(one day and one night) your farm costs you money(salaries and upkeep) and generates you money from passively selling crops and animals products.
The game is over if your farm reaches $0(you lose) or $10,000(you win).

## Design Patterns
- Decorator: used to upgrade the farmers and increase their affinities for animals or crops
- Builder: used to create the farm object
- Facade: used to provide a simplified interface between the farm system and Main.

## Requirements
1) A new world must start with at least 1 farm.
2) Farms can be of different types, such as an animal farm or a crop farm.
3) The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 daytime and 1 night time.
4) Passive currency is earned with each new day (not night). This passive currency income is generated from selling crops and animal products.
5) More currency can be made from farmer, animal, or crop affinities.
6) Farms can be upgraded once the farm has acquired enough currency. This means that the farm is expanded to grant it more land, which allows it to hold a greater numbers of animals and crops.
7) Farmers can have affinities for things such as growing crops and rearing animals.
8) Animals reside on farms, cows and sheep. The number depends on the level of the farm(number of pastures).
9) During night cycles predators come out.

## Recognized Commands
- buy sheep
- buy cow
- sell animal
- hire crop farmer
- hire animal rearer
- level up farm
- level up farmer
- upgrade farmer
- level up animal
- skip


