javac -cp .:lib/lanterna.jar:src/collectible/:src/entity:src/game:src/maze:src/mazeGeneration: src/game/Nethack.java src/collectible/*.java src/entity/*.java src/game/*.java src/maze/*.java src/mazeGeneration/Generation.java
cd src/game

java -cp .:../../lib/lanterna.jar:../maze:../mazeGeneration:../entity:../game:../collectible: Nethack
