#!/usr/bin/env bash
javac -cp .:lib/lanterna.jar:src/collectible/:src/entity:src/game:src/maze:src/mazeGeneration: src/game/Nethack.java src/collectible/*.java src/entity/*.java src/game/*.java src/maze/*.java src/mazeGeneration/Generation.java
if [ "$OSTYPE" == "linux-gnu" ]
then
	resize -s 40 100
	echo "linux boi"
else
	printf '\e[8;40;100t'
	echo "mac boi"
fi
cd src/game

java -cp .:../../lib/lanterna.jar:../maze:../mazeGeneration:../entity:../game:../collectible: Nethack
