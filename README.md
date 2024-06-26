
# Mangala Game

My project is Java RESTful Web Service used for Mancala/Kalah game. Two player can play game on
You can find the rules of the game from Wikipedia: https://en.wikipedia.org/wiki/Kalah.

# Board Setup

Each of the two players has his six pits in front of him. To the right of the six pits,
each player has a larger pit. At the start of the game, there are six stones in each
of the six round pits .

# Rules
## Game Play

The player who begins with the first move picks up all the stones in any of his
own six pits, and sows the stones on to the right, one in each of the following
pits, including his own big pit. No stones are put in the opponents' big pit. If the
player's last stone lands in his own big pit, he gets another turn. This can be
repeated several times before it's the other player's turn.

## Capturing Stones

During the game the pits are emptied on both sides. Always when the last stone
lands in an own empty pit, the player captures his own stone and all stones in the
opposite pit (the other player’s pit) and puts them in his own (big or little?) pit.

## The Game Ends
The game is over as soon as one of the sides runs out of stones. The player who
still has stones in his pits keeps them and puts them in his big pit. The winner of
the game is the player who has the most stones in his big pit.
You can also find some visual explanations of the game rules by running a
Google Search for Mancala or Kalaha game.

# Getting Started

## Requirements
- Apache Maven 3.6.3
- JDK 11

## Install
- git clone https://github.com/zeynepcinar/Mangala.git

## Run
- You can reach swagger endpoint documentation from: http://localhost:8081/swagger-ui/#/

### For run unit tests
```
- mvn clean install
- mvn clean test
```
