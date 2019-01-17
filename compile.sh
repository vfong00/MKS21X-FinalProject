#!/usr/bin/env bash
javac -cp .:lib/jcurses.jar:lib/lanterna.jar:src/menu:src/collectible/:src/entity:src/game:src/maze:src/mazeGeneration: src/game/Nethack.java src/collectible/*.java src/entity/*.java src/game/*.java src/maze/*.java src/mazeGeneration/Generation.java
chmod +x run.sh
./run.sh
