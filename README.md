# MKS21X-FinalProject
making a roguelike game

## linux
hi vincent
compile with javac -cp :../../lib/lanterna.jar:../game:../maze:../entity:Whatever.java

run with java -cp :../../lib/lanterna.jar:../game:../maze:../entity:Whatever


## devlog- moody
### 01-05-19
Day one of serious coding. Very little was done with the Lanterna library. Rather,
I focused on working on the underlying data structure. The code Vincent wrote used
the upper layer terminal graphics to handle logic was more of a proof of concept
so today was spent revamping Entity-Maze interactions at a lower level.

This involved me making the Tileable interface, which applies to anything that can
"exist". This was made as a workaround to the original plan of using a null object
to denote empty spaces. Lanerna stops execution if a null is attempted to print to
terminal.

I also moved a bunch of stuff into their own specific directory, while making setting
the class path a pain, it's a one time task typing it in and keeps the class logic
much more cohesive.

The next big step was to create one instance of the maze, and linking all the Entities
to this one instance of maze. Now asking a Player to move somewhere will update the
internal Player fields _and_ it's location in the map.

Air was also created. This is necessary because we had originally defined for
collision to work with other Entities, so all the empty spaces need _something_
not an Entity to move onto.

The majority of the work today is to ease up development later down the line.

edit: yeah the branch is called terrainGeneration but the refactoring was more
pressing in my opinion. I'll do the dungeon generation tomorrow :P

edit 2: quick idea, instead of having the player do nothing to collided entities
in the form of walls, have the player deal damage to all impacted entities and give
walls either impossibly high health or a regeneration factor (or not and make the
environment distructible)

~moody
