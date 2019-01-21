if [ "$OSTYPE" == "linux-gnu" ]
then
	resize -s 40 100
	echo "linux boi <3"
else
	printf '\e[8;40;100t'
	echo "aw frick its a mac >:("
fi

cd src/game
java -cp .:../tools:../../lib/lanterna.jar:../menu:../maze:../mazeGeneration:../entity:../game:../collectible: Nethack
