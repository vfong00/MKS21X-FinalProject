# MKS21X-FinalProject
making a roguelike game

## windows
lol

## os x/linux
chmod +x compile.sh  <br/>
./compile.sh  <br/>

## how to play
move with wasd  <br/>
'p' to generate new dungeon   <br/>
'q' to quit  <br/>
DO NOT HIT ARROW KEYS OR ELSE EVERYONE DIES  <br/>

## devlog- moody
### 01-05-19
Day one of serious coding. Very little was done with the Lanterna library. Rather,
I focused on working on the underlying data structure. The code Vincent wrote used
the upper layer terminal graphics to handle logic was more of a proof of concept
so today was spent revamping Entity-Maze interactions at a lower level.

This involved me making the Tileable interface, which applies to anything that can
"exist". This was made as a workaround to the original plan of using a null object
to denote empty spaces. Lanterna stops execution if a null is attempted to print to
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
environment destructible)

~moody

## devlog- moody
### 01-06-19
Terrain generation! I used a seperate data structure to handle the generation, and
copied over the output of that into the maze, rather than having the maze serve both
purposes at once.

## devlog- moody
### 01-07-19
Ported into screen, moved relevant generationFunctions into MazeGeneration

## devlog- moody
### 01-08-19
big dead lmao

## devlog- moody
### 01-09-19
Vincent worked on monsters, funny bug where monsters would not die, but become
moving Air tiles.

## devlog- moody
### 01-10-19
There were some issues in the branch screenPort where the terrainGeneration would
print onto the terminal, but the underlying data structure of terrainGeneration
would intermix with the proper terrain. This led to me making a new brach to work
ground up, from the point where terrain eneration last worked, and immediately start
moving that work into Screen. After that was sorted out, I began moving around
functions into their respective objects.

## devlog - Vincent
### 01-04-19
+ made extremely basic files (Nethack game file, Entity abstract class, Player)
+ found way to place interactable 'walls' within terminal
We are looking to integrate the underlying maze array and the terminal in some way.
Moody's working to create maze generation, and a better way than a crude Object[][].
I will be out until Sunday, as I have an all-day event to be at on Saturday.

### 01-06-19
- slept in, didn't do coding
+ discussed with Moody -- we decided to stick with dynamic updating, where the objects update their terminal position (as opposed to going through the maze array every time)
Also struggling a little with git branching; some of my files were missing for no apparent reason

### 01-07-19
- was big dead from studying for test; did no work besides that done in class (which wasn't much, because of the headache I had)

### 01-08-19
+ made Monster class, with movement
+ made an engage function, that lets player deal with monster
+ in Nethack, made a monster list, akin to calling a set of patches in Netlogo

One thing that isn't that great is the current implementation of attacking. Because of it, there are HP functions in Tileable, which doesn't fit with the purpose of the interface. Moody is thinking of a way to make it better.

### 01-09-19
- tried to make print function work, to no success (keeps disappearing)
+ fixed a bug where Monster wouldn't completely disappear after death (would roam as an air tile)

### 01-10-19
+ created collectible abstract class, and a working example (a weapon)
+ created terminal printing of player actions (such as collecting collectibles, fighting monsters)

### 01-11-19 and 01-12-19
I was on a trip on Saturday, and I spent most of Sunday recovering.

### 01-13-19
+ made status bar at bottom
+ added random hitting
+ added defense attributes
+ added armor collectible

### 01-14-19
+ did not commit, but started research into textCharacters and terminal things

### 01-15-19
+ switched out char fields for TextCharacters
+ made walls a little more snazzy

To do list (in order of approachability/importance/some ordering):
- aesthetics
- player inventory
- more collectibles
- not having the monster always run away from the Player
- figure out way to not have tileables spawn in a wall.
